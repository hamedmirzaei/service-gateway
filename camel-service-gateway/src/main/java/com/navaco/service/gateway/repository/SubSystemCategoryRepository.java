package com.navaco.service.gateway.repository;

import com.navaco.service.gateway.enums.SubSystemCategoryType;
import com.navaco.service.gateway.model.SubSystemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubSystemCategoryRepository extends JpaRepository<SubSystemCategory, Long> {
    public SubSystemCategory findBySubSystemCategoryType(SubSystemCategoryType subSystemCategoryType);
}
