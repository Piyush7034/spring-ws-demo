package com.example.springwsdemo.gen.response;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
public class ResponseBody {
    @XmlElement(name = "consultarResponse", namespace = "http://endpoint.wsconsultadni.reniec.gob.pe/")
    private ConsultarResponse consultarResponse;

    public ConsultarResponse getConsultarResponse() {
        return consultarResponse;
    }

    public void setConsultarResponse(ConsultarResponse consultarResponse) {
        this.consultarResponse = consultarResponse;
    }
}
