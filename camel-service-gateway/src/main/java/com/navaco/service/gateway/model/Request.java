package com.navaco.service.gateway.model;

import com.navaco.service.gateway.enums.ActionType;
import com.navaco.service.gateway.enums.RequestType;

import java.io.Serializable;

public class Request implements Serializable {

    private RequestType requestType;
    private ActionType actionType;

    public Request() {
    }

    public Request(RequestType requestType, ActionType actionType) {
        this.requestType = requestType;
        this.actionType = actionType;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestType=" + requestType +
                ", actionType=" + actionType +
                '}';
    }
}
