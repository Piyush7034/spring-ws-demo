package com.example.springwsdemo.gen.response;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
public class ResponseEnvelope {
    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private ResponseBody responseBody;

    public ResponseBody getResponseBody() { return responseBody; }
    public void setResponseBody(ResponseBody value) { this.responseBody = value; }
}
