package com.navaco.service.gateway.enums;

public enum ActionType {
    ADD("ADD"),
    GET("GET"),
    GET_ALL("GET_ALL");

    private final String action;

    /**
     * @param action
     */
    ActionType(final String action) {
        this.action = action;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return action;
    }

}
