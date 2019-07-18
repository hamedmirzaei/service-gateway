package com.navaco.service.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:webservice-definition-beans.xml"})
public class SoapWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapWebserviceApplication.class, args);
    }

}
