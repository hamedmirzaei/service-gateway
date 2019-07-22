package com.navaco.service.gateway.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CONTEXT_SERVICE_MAPPING")
public class ContextServiceMapping implements Serializable {

    @Id
    @Column(name = "CSM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CONTEXT", unique = true, nullable = false)
    private String context;

    @Column(name = "SERVICE", nullable = false)
    private String service;

    public ContextServiceMapping() {
    }

    public ContextServiceMapping(String context, String service) {
        this.context = context;
        this.service = service;
    }

    public ContextServiceMapping(Long id, String context, String service) {
        this.id = id;
        this.context = context;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "ContextServiceMapping{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", service='" + service + '\'' +
                '}';
    }
}
