package com.navaco.service.gateway.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Greeting")
public class Greeting implements Serializable {

	private String message;
	private Date date;

	public Greeting() {
	}

	public Greeting(String message, Date date) {
		this.message = message;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Greeting{" +
				"message='" + message + '\'' +
				", date=" + date +
				'}';
	}
}
