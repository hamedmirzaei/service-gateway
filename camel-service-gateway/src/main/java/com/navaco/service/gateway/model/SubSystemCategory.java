package com.navaco.service.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.navaco.service.gateway.enums.SubSystemCategoryType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = SubSystemCategory.SUB_SYSTEM_CATEGORY_TABLE_NAME)
public class SubSystemCategory {

    public static final String SUB_SYSTEM_CATEGORY_TABLE_NAME = "SUB_SYSTEM_CATEGORY";
    public static final String SUB_SYSTEM_CATEGORY_SEQUENCE_NAME = SUB_SYSTEM_CATEGORY_TABLE_NAME + "_SEQ";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_generator")
    @SequenceGenerator(name="cat_generator", sequenceName = SubSystemCategory.SUB_SYSTEM_CATEGORY_SEQUENCE_NAME)
    private Long id;

    @Column(name = "CATEGORY_TYPE", unique = true, nullable = false)
    private SubSystemCategoryType subSystemCategoryType;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subSystemCategory")
    private List<ContextServiceMapping> contextServiceMappingList;

    public SubSystemCategory() {
    }

    public SubSystemCategory(SubSystemCategoryType subSystemCategoryType) {
        this.subSystemCategoryType = subSystemCategoryType;
    }

    public SubSystemCategory(SubSystemCategoryType subSystemCategoryType, List<ContextServiceMapping> contextServiceMappingList) {
        this.subSystemCategoryType = subSystemCategoryType;
        this.contextServiceMappingList = contextServiceMappingList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubSystemCategoryType getSubSystemCategoryType() {
        return subSystemCategoryType;
    }

    public void setSubSystemCategoryType(SubSystemCategoryType subSystemCategoryType) {
        this.subSystemCategoryType = subSystemCategoryType;
    }

    public List<ContextServiceMapping> getContextServiceMappingList() {
        return contextServiceMappingList;
    }

    public void setContextServiceMappingList(List<ContextServiceMapping> contextServiceMappingList) {
        this.contextServiceMappingList = contextServiceMappingList;
    }

    @Override
    public String toString() {
        return "SubSystemCategoryType{" +
                "id=" + id +
                ", subSystemCategoryType='" + subSystemCategoryType + '\'' +
                '}';
    }

}
