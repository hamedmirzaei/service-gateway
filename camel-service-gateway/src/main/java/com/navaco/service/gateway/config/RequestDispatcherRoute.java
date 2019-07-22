package com.navaco.service.gateway.config;

import com.navaco.service.gateway.model.Request;
import com.navaco.service.gateway.processor.AddRequestHeadersProcessor;
import com.navaco.service.gateway.processor.RemoveHeaderProcessor;
import com.navaco.service.gateway.service.Greeting;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpMethods;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RequestDispatcherRoute extends RouteBuilder {

    private final String ACCOUNT_EUREKA_SERVICE_NAME = "account-service";

    @Value("${rest.port}")
    private String port;

    private RemoveHeaderProcessor removeHeaderProcessor;
    private AddRequestHeadersProcessor addRequestHeadersProcessor;

    @PostConstruct
    public void post() {
        removeHeaderProcessor = new RemoveHeaderProcessor();
        addRequestHeadersProcessor = new AddRequestHeadersProcessor();
    }

    @Override
    public void configure() throws Exception {

        setupRestConfiguration();

        rest("/dispatcher")
                .post()
                .description("Make a request").outType(Greeting.class)
                .consumes("application/json").type(Request.class)
                .route()
                .log("############## Request is: ${body}")
                .process(addRequestHeadersProcessor)
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
                .log("############## Account Another Unimplemented Action")
                .endChoice()
                .otherwise()
                .log("############## Another Unimplemented Request")
                .endChoice()
                .endRest();
    }

    private void setupRestConfiguration() {
        restConfiguration()
                .host("localhost")
                .port(port)
                .bindingMode(RestBindingMode.json)
                .apiProperty("api.title", "Dispatcher Camel API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true");
    }

}
