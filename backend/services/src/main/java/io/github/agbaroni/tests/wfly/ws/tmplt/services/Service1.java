package io.github.agbaroni.tests.wfly.ws.tmplt.services;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

// @XmlRootElement(name = "foo")
@HandlerChain(file = "handler-chain.xml")
@WebService // targetNamespace = "http://localhost:8080/test"
public class Service1 {

    @WebMethod
    public @WebResult(name = "output")
	Output getOutput(@WebParam(name = "input")
			 @XmlElement(required = true)
			 Input input) {
	Output o = new Output();

	o.setField(input.getField());

	return o;
    }
}
