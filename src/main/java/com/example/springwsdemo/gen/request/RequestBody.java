package com.example.springwsdemo.gen.request;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
public class RequestBody {
    @XmlElement(name = "consultar", namespace = "http://endpoint.wsconsultadni.reniec.gob.pe/")
    private Consultar consultar;

    public Consultar getConsultar() { return consultar; }
    public void setConsultar(Consultar value) { this.consultar = value; }
}
