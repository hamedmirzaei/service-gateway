package com.navaco.service.gateway.config;

import com.google.gson.Gson;
import com.navaco.service.gateway.model.Request;
import com.navaco.service.gateway.processor.RemoveHeaderProcessor;
import com.navaco.service.gateway.service.Greeting;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpMethods;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class RequestDispatcherRoute extends RouteBuilder {

    private final String ACCOUNT_EUREKA_SERVICE_NAME = "account-service";

    @Value("${rest.port}")
    private String port;

    private Gson gson;
    private RemoveHeaderProcessor removeHeaderProcessor;

    @PostConstruct
    public void post() {
        gson = new Gson();
        removeHeaderProcessor = new RemoveHeaderProcessor();
    }

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .host("localhost")
                .port(port)
                .bindingMode(RestBindingMode.json)
                .apiProperty("api.title", "Dispatcher Camel API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true");

        rest("/dispatcher")
                .post()
                .description("Say hello to person/thing").outType(Greeting.class)
                .param().name("name").type(RestParamType.path).description("Person/Thing name").dataType("string").endParam()
                .consumes("application/json").type(Request.class)
                .route()
                .log("############## Request is: ${body}")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Request request = gson.fromJson(exchange.getIn().getBody(String.class), Request.class);
                        exchange.getIn().setHeader("requestType", request.getRequestType());
                        exchange.getIn().setHeader("actionType", request.getActionType());
                    }
                })
                .threads(5)
                .choice()
                    .when(simple("${header.requestType} == 'ACCOUNT'"))
                        .loadBalance().roundRobin()
                        .choice()
                            .when(simple("${header.actionType} == 'GET'"))
                                .process(removeHeaderProcessor)
                                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.GET))
                                .serviceCall(ACCOUNT_EUREKA_SERVICE_NAME + "/accounts/1")
                            .otherwise()
                                .log("############## Account Unknown Action")
                        .endChoice()
                    .otherwise()
                        .log("############## Unknown Request")
                .endChoice()
                .endRest();
    }
}
