package com.navaco.service.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.navaco.service.gateway.enums.ServiceStatusType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SERVICE_STATUS")
public class ServiceStatus {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "svc_generator")
    @SequenceGenerator(name="svc_generator", sequenceName = "SERVICE_STATUS_SEQ")
    private Long id;

    @Column(name = "STATUS_NAME", unique = true, nullable = false)
    //@Enumerated(EnumType.STRING)
    private ServiceStatusType statusName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceStatus")
    private List<ContextServiceMapping> contextServiceMappingList;

    public ServiceStatus() {
    }

    public ServiceStatus(ServiceStatusType statusName) {
        this.statusName = statusName;
    }

    public ServiceStatus(ServiceStatusType statusName, List<ContextServiceMapping> contextServiceMappingList) {
        this.statusName = statusName;
        this.contextServiceMappingList = contextServiceMappingList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceStatusType getStatusName() {
        return statusName;
    }

    public void setStatusName(ServiceStatusType statusName) {
        this.statusName = statusName;
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
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
