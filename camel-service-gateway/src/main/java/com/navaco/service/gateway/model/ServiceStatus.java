package com.navaco.service.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.navaco.service.gateway.enums.ServiceStatusType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = ServiceStatus.SERVICE_STATUS_TABLE_NAME)
public class ServiceStatus {

    public static final String SERVICE_STATUS_TABLE_NAME = "SERVICE_STATUS";
    public static final String SERVICE_STATUS_SEQUENCE_NAME = SERVICE_STATUS_TABLE_NAME + "_SEQ";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "svc_generator")
    @SequenceGenerator(name="svc_generator", sequenceName = ServiceStatus.SERVICE_STATUS_SEQUENCE_NAME)
    private Long id;

    @Column(name = "STATUS_TYPE", unique = true, nullable = false)
    private ServiceStatusType serviceStatusType;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceStatus")
    private List<ContextServiceMapping> contextServiceMappingList;

    public ServiceStatus() {
    }

    public ServiceStatus(ServiceStatusType serviceStatusType) {
        this.serviceStatusType = serviceStatusType;
    }

    public ServiceStatus(ServiceStatusType serviceStatusType, List<ContextServiceMapping> contextServiceMappingList) {
        this.serviceStatusType = serviceStatusType;
        this.contextServiceMappingList = contextServiceMappingList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceStatusType getServiceStatusType() {
        return serviceStatusType;
    }

    public void setServiceStatusType(ServiceStatusType serviceStatusType) {
        this.serviceStatusType = serviceStatusType;
    }

    public List<ContextServiceMapping> getContextServiceMappingList() {
        return contextServiceMappingList;
    }

    public void setContextServiceMappingList(List<ContextServiceMapping> contextServiceMappingList) {
        this.contextServiceMappingList = contextServiceMappingList;
    }

    @Override
    public String toString() {
        return "ServiceStatusType{" +
                "id=" + id +
                ", serviceStatusType='" + serviceStatusType + '\'' +
                '}';
    }
}
