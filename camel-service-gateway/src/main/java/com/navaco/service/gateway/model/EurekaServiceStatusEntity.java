package com.navaco.service.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.navaco.service.gateway.enums.EurekaServiceStatusType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = EurekaServiceStatusEntity.EUREKA_SERVICE_STATUS_TABLE_NAME)
public class EurekaServiceStatusEntity {

    public static final String EUREKA_SERVICE_STATUS_TABLE_NAME = "EUREKA_SERVICE_STATUS";
    public static final String EUREKA_SERVICE_STATUS_SEQUENCE_NAME = EUREKA_SERVICE_STATUS_TABLE_NAME + "_SEQ";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "svc_generator")
    @SequenceGenerator(name="svc_generator", sequenceName = EurekaServiceStatusEntity.EUREKA_SERVICE_STATUS_SEQUENCE_NAME)
    private Long id;

    @Column(name = "STATUS_TYPE", unique = true, nullable = false)
    private EurekaServiceStatusType eurekaServiceStatusType;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eurekaServiceStatusEntity")
    private List<ContextPathEurekaServiceMappingEntity> contextPathEurekaServiceMappingEntityList;

    public EurekaServiceStatusEntity() {
    }

    public EurekaServiceStatusEntity(EurekaServiceStatusType eurekaServiceStatusType) {
        this.eurekaServiceStatusType = eurekaServiceStatusType;
    }

    public EurekaServiceStatusEntity(EurekaServiceStatusType eurekaServiceStatusType, List<ContextPathEurekaServiceMappingEntity> contextPathEurekaServiceMappingEntityList) {
        this.eurekaServiceStatusType = eurekaServiceStatusType;
        this.contextPathEurekaServiceMappingEntityList = contextPathEurekaServiceMappingEntityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EurekaServiceStatusType getEurekaServiceStatusType() {
        return eurekaServiceStatusType;
    }

    public void setEurekaServiceStatusType(EurekaServiceStatusType eurekaServiceStatusType) {
        this.eurekaServiceStatusType = eurekaServiceStatusType;
    }

    public List<ContextPathEurekaServiceMappingEntity> getContextPathEurekaServiceMappingEntityList() {
        return contextPathEurekaServiceMappingEntityList;
    }

    public void setContextPathEurekaServiceMappingEntityList(List<ContextPathEurekaServiceMappingEntity> contextPathEurekaServiceMappingEntityList) {
        this.contextPathEurekaServiceMappingEntityList = contextPathEurekaServiceMappingEntityList;
    }

    @Override
    public String toString() {
        return "EurekaServiceStatusType{" +
                "id=" + id +
                ", eurekaServiceStatusType='" + eurekaServiceStatusType + '\'' +
                '}';
    }
}
