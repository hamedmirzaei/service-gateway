package com.navaco.service.gateway.model;

import com.navaco.service.gateway.enums.ServiceStatusEnum;

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
    private ServiceStatusEnum statusName;

    @OneToMany(mappedBy = "serviceStatus")
    private List<ContextServiceMapping> contextServiceMappingList;

    public ServiceStatus() {
    }

    public ServiceStatus(ServiceStatusEnum statusName) {
        this.statusName = statusName;
    }

    public ServiceStatus(ServiceStatusEnum statusName, List<ContextServiceMapping> contextServiceMappingList) {
        this.statusName = statusName;
        this.contextServiceMappingList = contextServiceMappingList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceStatusEnum getStatusName() {
        return statusName;
    }

    public void setStatusName(ServiceStatusEnum statusName) {
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
        return "ServiceStatusEnum{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
