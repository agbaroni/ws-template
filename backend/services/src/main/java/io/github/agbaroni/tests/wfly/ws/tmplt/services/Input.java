package io.github.agbaroni.tests.wfly.ws.tmplt.services;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Input {

    @XmlElement(required = true)
    private String field;

    public String getField() {
	return field;
    }

    public void setField(String field) {
	this.field = field;
    }
}
