package com.navaco.service.gateway.repository;

import com.navaco.service.gateway.enums.SubSystemCategoryType;
import com.navaco.service.gateway.model.SubSystemCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubSystemCategoryRepository extends JpaRepository<SubSystemCategoryEntity, Long> {
    public SubSystemCategoryEntity findBySubSystemCategoryType(SubSystemCategoryType subSystemCategoryType);
}
