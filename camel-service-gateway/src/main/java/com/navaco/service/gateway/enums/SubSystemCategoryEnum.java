package com.navaco.service.gateway.enums;

public enum SubSystemCategoryEnum {
    ARZI("ARZI"),
    CHANNEL_MANAGER("CHANNEL_MANAGER");

    private String categoryName;

    private SubSystemCategoryEnum(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
