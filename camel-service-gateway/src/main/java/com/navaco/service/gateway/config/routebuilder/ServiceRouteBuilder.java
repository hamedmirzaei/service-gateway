package com.navaco.service.gateway.config.routebuilder;

import com.navaco.service.gateway.domain.ContextPathEurekaServiceMappingEntity;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpMethods;

public class ServiceRouteBuilder extends RouteBuilder {

    private ContextPathEurekaServiceMappingEntity contextPathEurekaServiceMappingEntity;

    public ServiceRouteBuilder(CamelContext context, ContextPathEurekaServiceMappingEntity contextPathEurekaServiceMappingEntity) {
        super(context);
        this.contextPathEurekaServiceMappingEntity = contextPathEurekaServiceMappingEntity;
    }

    @Override
    public void configure() throws Exception {
        // redirect Http.GET requests to appropriate micro-service
        from("spark-rest:get:services/" + contextPathEurekaServiceMappingEntity.getContextPath())
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.GET))
                .setHeader("in_uri", simple("${header[CamelHttpUri].replace('/services', '')}"))
                .removeHeader("CamelHttp*")
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .serviceCall(contextPathEurekaServiceMappingEntity.getEurekaServiceName() + "/" + "${header[in_uri]}");

        // redirect Http.POST requests to appropriate micro-service
        from("spark-rest:post:services/" + contextPathEurekaServiceMappingEntity.getContextPath())
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.POST))
                .setHeader("in_uri", simple("${header[CamelHttpUri].replace('/services', '')}"))
                .removeHeader("CamelHttp*")
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .serviceCall(contextPathEurekaServiceMappingEntity.getEurekaServiceName() + "/" + "${header[in_uri]}");

        // redirect Http.DELETE requests to appropriate micro-service
        from("spark-rest:delete:services/" + contextPathEurekaServiceMappingEntity.getContextPath())
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.DELETE))
                .setHeader("in_uri", simple("${header[CamelHttpUri].replace('/services', '')}"))
                .removeHeader("CamelHttp*")
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .serviceCall(contextPathEurekaServiceMappingEntity.getEurekaServiceName() + "/" + "${header[in_uri]}");

        // redirect Http.PUT requests to appropriate micro-service
        from("spark-rest:put:services/" + contextPathEurekaServiceMappingEntity.getContextPath())
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.PUT))
                .setHeader("in_uri", simple("${header[CamelHttpUri].replace('/services', '')}"))
                .removeHeader("CamelHttp*")
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .serviceCall(contextPathEurekaServiceMappingEntity.getEurekaServiceName() + "/" + "${header[in_uri]}");

        // redirect Http.PATCH requests to appropriate micro-service
        from("spark-rest:patch:services/" + contextPathEurekaServiceMappingEntity.getContextPath())
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.PATCH))
                .setHeader("in_uri", simple("${header[CamelHttpUri].replace('/services', '')}"))
                .removeHeader("CamelHttp*")
                .removeHeader(Exchange.HTTP_PATH)
                .removeHeader(Exchange.HTTP_URI)
                .serviceCall(contextPathEurekaServiceMappingEntity.getEurekaServiceName() + "/" + "${header[in_uri]}");
    }
}
