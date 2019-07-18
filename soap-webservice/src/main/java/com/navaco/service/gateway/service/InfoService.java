package com.navaco.service.gateway.service;

import com.navaco.service.gateway.model.Greeting;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "InfoService")
public interface InfoService {
    @WebMethod()
    @WebResult(name = "Greeting")
    public Greeting sayHowAreYou(@WebParam(name = "GreetingsRequest") String name);
}