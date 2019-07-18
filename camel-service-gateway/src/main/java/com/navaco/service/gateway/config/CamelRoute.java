package com.navaco.service.gateway.config;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jetty:http://localhost:8092/transfer")
        //from("direct:start")
                .log("############# here")
                .setBody(constant("Hamed"))
                .setHeader(CxfConstants.OPERATION_NAME, constant("sayHello"))
                .setHeader(CxfConstants.OPERATION_NAMESPACE,
                        constant("http://service.gateway.service.navaco.com/"))

                // Invoke our test service using CXF
                .to("cxf://http://localhost:8094/services/GreetingService"
                        + "?serviceClass=com.navaco.service.gateway.service.GreetingService"
                        + "&wsdlURL=/wsdl/GreetingService.wsdl")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        exchange.getIn();
                    }
                })

                // You can retrieve fields from the response using the Simple language
                .log("############## The title is: ${body[0]}")

                .end();
    }
}
