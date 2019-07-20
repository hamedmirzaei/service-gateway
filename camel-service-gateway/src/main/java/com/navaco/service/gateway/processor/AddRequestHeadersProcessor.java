package com.navaco.service.gateway.processor;

import com.google.gson.Gson;
import com.navaco.service.gateway.model.Request;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class AddRequestHeadersProcessor implements Processor {

    private Gson gson = new Gson();

    @Override
    public void process(Exchange exchange) throws Exception {
        Request request = gson.fromJson(exchange.getIn().getBody(String.class), Request.class);
        exchange.getIn().setHeader("requestType", request.getRequestType());
        exchange.getIn().setHeader("actionType", request.getActionType());
    }
}
