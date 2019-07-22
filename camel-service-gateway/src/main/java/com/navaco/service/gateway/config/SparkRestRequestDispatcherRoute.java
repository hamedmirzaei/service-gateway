package com.navaco.service.gateway.config;

import com.navaco.service.gateway.model.ContextServiceMapping;
import com.navaco.service.gateway.service.ContextServiceMappingService;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpMethods;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SparkRestRequestDispatcherRoute extends RouteBuilder {

    private ContextServiceMappingService contextServiceMappingService;

    @Value("${rest.port}")
    private String port;

    @Autowired
    public SparkRestRequestDispatcherRoute(ContextServiceMappingService contextServiceMappingService) {
        this.contextServiceMappingService = contextServiceMappingService;
    }

    @Override
    public void configure() throws Exception {

        // rest configuration
        setupRestConfiguration();

        // mapping of context strings to eureka service names
        List<ContextServiceMapping> contextServiceMappings = contextServiceMappingService.getAllContextServiceMapping();

        // for health check
        from("spark-rest:get:health")
                .transform().constant("Service is Up");

        // for each single micro-service which expose a rest API
        for (ContextServiceMapping contextServiceMapping : contextServiceMappings) {
            // redirect Http.GET requests to appropriate micro-service
            from("spark-rest:get:" + contextServiceMapping.getContext())
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.GET))
                .setHeader("in_uri", simple("${header[CamelHttpUri]}"))
                .removeHeader("CamelHttp*")
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .serviceCall(contextServiceMapping.getService() + "/" + "${header[in_uri]}");

            // redirect Http.POST requests to appropriate micro-service
            from("spark-rest:post:" + contextServiceMapping.getContext())
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.POST))
                .setHeader("in_uri", simple("${header[CamelHttpUri]}"))
                .removeHeader("CamelHttp*")
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .serviceCall(contextServiceMapping.getService() + "/" + "${header[in_uri]}");

            // redirect Http.DELETE requests to appropriate micro-service
            from("spark-rest:delete:" + contextServiceMapping.getContext())
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.DELETE))
                .setHeader("in_uri", simple("${header[CamelHttpUri]}"))
                .removeHeader("CamelHttp*")
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .serviceCall(contextServiceMapping.getService() + "/" + "${header[in_uri]}");

            // redirect Http.PUT requests to appropriate micro-service
            from("spark-rest:put:" + contextServiceMapping.getContext())
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.PUT))
                .setHeader("in_uri", simple("${header[CamelHttpUri]}"))
                .removeHeader("CamelHttp*")
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .serviceCall(contextServiceMapping.getService() + "/" + "${header[in_uri]}");

            // redirect Http.PATCH requests to appropriate micro-service
            from("spark-rest:patch:" + contextServiceMapping.getContext())
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.PATCH))
                .setHeader("in_uri", simple("${header[CamelHttpUri]}"))
                .removeHeader("CamelHttp*")
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .serviceCall(contextServiceMapping.getService() + "/" + "${header[in_uri]}");
        }
    }

    private void setupRestConfiguration() {
        restConfiguration()
                .host("localhost")
                .port(port)
                .bindingMode(RestBindingMode.json)
                .componentProperty("matchOnUriPrefix", "true")
                .apiProperty("api.title", "Dispatcher Camel API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true");
    }

}
