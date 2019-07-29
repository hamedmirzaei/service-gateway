package com.navaco.service.gateway.controller;

import com.navaco.service.gateway.config.RequestDispatcher;
import com.navaco.service.gateway.service.ContextServiceMappingService;
import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/camel")
public class CamelController {

    private ContextServiceMappingService contextServiceMappingService;
    private CamelContext camelContext;

    @Autowired
    public CamelController(ContextServiceMappingService contextServiceMappingService, CamelContext camelContext) {
        this.contextServiceMappingService = contextServiceMappingService;
        this.camelContext = camelContext;
    }

    @GetMapping("/refresh")
    public ResponseEntity refreshRoutes() {
        RequestDispatcher.refresh(contextServiceMappingService, camelContext);
        return ResponseEntity.ok("CamelContext Refreshed Successfully");
    }

    @GetMapping("/health")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("Server is UP");
    }
}
