package com.example.springwsdemo.gen.request;

import jakarta.xml.bind.annotation.*;
import org.springframework.ws.soap.SoapBody;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlType(propOrder = {"body"})
public class RequestEnvelope {
    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private RequestBody body;

    public RequestBody getBody() { return body; }
    public void setBody(RequestBody value) { this.body = value; }
}
