package com.navaco.service.gateway.config;

import com.navaco.service.gateway.service.Greeting;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SOAPInvokerRoute extends RouteBuilder {

    @Value("${rest.port}")
    private String port;

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .host("localhost")
                .port(port)
                //.bindingMode(RestBindingMode.json)
                .apiProperty("api.title", "SOAP/REST Camel API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true");

        rest("/soap")
                .get("/hello/{name}")
                .description("Say hello to person/thing").outType(Greeting.class)
                .param().name("name").type(RestParamType.path).description("Person/Thing name").dataType("string").endParam()
                .route()
                .setBody(simple("${header.name}"))
                .setHeader(CxfConstants.OPERATION_NAME, constant("sayHello"))
                .setHeader(CxfConstants.OPERATION_NAMESPACE,
                        constant("http://service.gateway.service.navaco.com/"))
                // Invoke soap web service using CXF
                .to("cxf://http://localhost:8094/services/GreetingService"
                        + "?serviceClass=com.navaco.service.gateway.service.GreetingService"
                        + "&wsdlURL=/wsdl/GreetingService.wsdl")
                .marshal().json(JsonLibrary.Jackson)
                .log("############## The greeting is: ${body}")
                .endRest()
                .get("/bye/{name}")
                .description("Say bye to person/thing").outType(Greeting.class)
                .param().name("name").type(RestParamType.path).description("Person/Thing name").dataType("string").endParam()
                .route()
                .setBody(simple("${header.name}"))
                .setHeader(CxfConstants.OPERATION_NAME, constant("sayBye"))
                .setHeader(CxfConstants.OPERATION_NAMESPACE,
                        constant("http://service.gateway.service.navaco.com/"))
                // Invoke soap web service using CXF
                .to("cxf://http://localhost:8094/services/GreetingService"
                        + "?serviceClass=com.navaco.service.gateway.service.GreetingService"
                        + "&wsdlURL=/wsdl/GreetingService.wsdl")
                .marshal().json(JsonLibrary.Jackson)
                .log("############## The greeting is: ${body}")
                .endRest();
    }
}
