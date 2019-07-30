package com.navaco.service.gateway.enums;

public enum ServiceStatusType {
    PUBLISHED("PUBLISHED"),
    TESTED("TESTED"),
    INACTIVE("INACTIVE");

    private String statusName;

    private ServiceStatusType(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
