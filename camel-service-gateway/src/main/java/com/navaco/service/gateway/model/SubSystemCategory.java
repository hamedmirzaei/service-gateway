package com.navaco.service.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.navaco.service.gateway.enums.SubSystemCategoryType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SUB_SYSTEM_CATEGORY")
public class SubSystemCategory {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_generator")
    @SequenceGenerator(name="cat_generator", sequenceName = "SUB_SYSTEM_CATEGORY_SEQ")
    private Long id;

    @Column(name = "CATEGORY_NAME", unique = true, nullable = false)
    //@Enumerated(EnumType.STRING)
    private SubSystemCategoryType categoryName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subSystemCategory")
    private List<ContextServiceMapping> contextServiceMappingList;

    public SubSystemCategory() {
    }

    public SubSystemCategory(SubSystemCategoryType categoryName) {
        this.categoryName = categoryName;
    }

    public SubSystemCategory(SubSystemCategoryType categoryName, List<ContextServiceMapping> contextServiceMappingList) {
        this.categoryName = categoryName;
        this.contextServiceMappingList = contextServiceMappingList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubSystemCategoryType getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(SubSystemCategoryType categoryName) {
        this.categoryName = categoryName;
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
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

}
