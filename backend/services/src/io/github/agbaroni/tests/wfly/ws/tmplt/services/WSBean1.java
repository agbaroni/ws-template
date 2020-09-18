package io.github.agbaroni.tests.wfly.ws.tmplt.services;

import io.github.agbaroni.tests.wfly.ws.tmplt.services.Bean1;

import javax.ejb.EJB;
import javax.jws.WebService;

@WebService
public class Bean1 {

    @EJB
    private Bean1 bean1;

    @WebMethod
    public String getName() {
	return bean1.getName();
    }
}
