package com.navaco.service.gateway.enums;

public enum ServiceStatusEnum {
    PUBLISHED("PUBLISHED"),
    TESTED("TESTED"),
    INACTIVE("INACTIVE");

    private String statusName;

    private ServiceStatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
