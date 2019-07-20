package com.navaco.service.gateway.enums;

public enum RequestType {
    ACCOUNT("ACCOUNT"),
    OTHER("OTHER");

    private final String request;

    /**
     * @param request
     */
    RequestType(final String request) {
        this.request = request;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return request;
    }

}
