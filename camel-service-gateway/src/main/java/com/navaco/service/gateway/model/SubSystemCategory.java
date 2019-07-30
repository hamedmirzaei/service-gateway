package com.navaco.service.gateway.model;

import com.navaco.service.gateway.enums.SubSystemCategoryEnum;

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
    private SubSystemCategoryEnum categoryName;

    @OneToMany(mappedBy = "subSystemCategory")
    private List<ContextServiceMapping> contextServiceMappingList;

    public SubSystemCategory() {
    }

    public SubSystemCategory(SubSystemCategoryEnum categoryName) {
        this.categoryName = categoryName;
    }

    public SubSystemCategory(SubSystemCategoryEnum categoryName, List<ContextServiceMapping> contextServiceMappingList) {
        this.categoryName = categoryName;
        this.contextServiceMappingList = contextServiceMappingList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubSystemCategoryEnum getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(SubSystemCategoryEnum categoryName) {
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
        return "SubSystemCategoryEnum{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

}
