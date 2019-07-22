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

        setupRestConfiguration();

        List<ContextServiceMapping> contextServiceMappings = contextServiceMappingService.getAllContextServiceMapping();

        from("spark-rest:get:health")
                .transform().constant("Service is Up");

        for (ContextServiceMapping contextServiceMapping : contextServiceMappings) {
            from("spark-rest:get:accounts")
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.GET))
                .setHeader("in_uri", simple("${header[CamelHttpUri]}"))
                .removeHeader("CamelHttp*")
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .serviceCall(contextServiceMapping.getService() + "/" + "${header[in_uri]}")
                .convertBodyTo(String.class);

            from("spark-rest:post:" + contextServiceMapping.getContext())
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.POST))
                .setHeader("in_uri", simple("${header[CamelHttpUri]}"))
                .removeHeader("CamelHttp*")
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .serviceCall(contextServiceMapping.getService() + "/" + "${header[in_uri]}");

            from("spark-rest:delete:" + contextServiceMapping.getContext())
                    .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.DELETE))
                    .serviceCall(contextServiceMapping.getService());

            from("spark-rest:put:" + contextServiceMapping.getContext())
                    .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.PUT))
                    .serviceCall(contextServiceMapping.getService());

            from("spark-rest:patch:" + contextServiceMapping.getContext())
                    .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.PATCH))
                    .serviceCall(contextServiceMapping.getService());
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
