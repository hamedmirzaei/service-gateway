package com.navaco.service.gateway.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RemoveHeaderProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().removeHeaders("CamelHttp*");
        exchange.getIn().removeHeader(Exchange.HTTP_PATH);
        exchange.getIn().removeHeader(Exchange.HTTP_URI);
    }
}
