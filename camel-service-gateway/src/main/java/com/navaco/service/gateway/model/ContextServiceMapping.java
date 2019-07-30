package com.navaco.service.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = ContextServiceMapping.CONTEXT_SERVICE_MAPPING_TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class ContextServiceMapping implements Serializable {

    public static final String CONTEXT_SERVICE_MAPPING_TABLE_NAME = "CONTEXT_SERVICE_MAPPING";
    public static final String CONTEXT_SERVICE_MAPPING_SEQUENCE_NAME = CONTEXT_SERVICE_MAPPING_TABLE_NAME + "_SEQ";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ctx_svc_generator")
    @SequenceGenerator(name="ctx_svc_generator", sequenceName = ContextServiceMapping.CONTEXT_SERVICE_MAPPING_SEQUENCE_NAME)
    private Long id;

    @Column(name = "CONTEXT_PATH", unique = true, nullable = false)
    private String context;

    @Column(name = "EUREKA_SERVICE_NAME", nullable = false)
    private String service;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICE_STATUS.ID")
    private ServiceStatus serviceStatus;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUB_SYSTEM_CATEGORY.ID")
    private SubSystemCategory subSystemCategory;

    @Column(nullable = false, updatable = false, name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false, name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

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

    public ContextServiceMapping(String context, String service, ServiceStatus serviceStatus, SubSystemCategory subSystemCategory) {
        this.context = context;
        this.service = service;
        this.serviceStatus = serviceStatus;
        this.subSystemCategory = subSystemCategory;
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

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public SubSystemCategory getSubSystemCategory() {
        return subSystemCategory;
    }

    public void setSubSystemCategory(SubSystemCategory subSystemCategory) {
        this.subSystemCategory = subSystemCategory;
    }

    @Override
    public String toString() {
        return "ContextServiceMapping{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", service='" + service + '\'' +
                ", serviceStatus=" + serviceStatus +
                ", subSystemCategory=" + subSystemCategory +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
