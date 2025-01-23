package com.example.springwsdemo;

import com.example.springwsdemo.gen.*;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class ReniecSoapClient extends WebServiceGatewaySupport {

    private static final String ENDPOINT_URL = "https://jfloresh.reniec.gob.pe:443/wsconsultadni/ConsultaDniService";

    public ReniecSoapClient() {
        setDefaultUri(ENDPOINT_URL);
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.springwsdemo.gen");
        setMarshaller(marshaller);
        setUnmarshaller(marshaller);
    }

    public ResultadoConsulta consultarDni(String nuDniConsulta, String nuDniUsuario, String nuRucUsuario, String password) {
        PeticionConsulta request = new ObjectFactory().createPeticionConsulta();
        request.setNuDniConsulta(nuDniConsulta);
        request.setNuDniUsuario(nuDniUsuario);
        request.setNuRucUsuario(nuRucUsuario);
        request.setPassword(password);

        try {
            ResultadoConsulta resultadoConsulta = (ResultadoConsulta) getWebServiceTemplate()
//                    .marshalSendAndReceive(ENDPOINT_URL, request,
//                            new SoapActionCallback("http://endpoint.wsconsultadni.reniec.gob.pe/SRELServiceService/consultarRequest"));
                    .marshalSendAndReceive(request);

            return resultadoConsulta;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        return "";
    }

    public ResultadoConsulta consultarCertificado(String accessToken, String nuDniConsulta, String nuRucUsuario) {
        PeticionConsultaCertificado request = new PeticionConsultaCertificado();
        request.setAccessToken(accessToken);
        request.setNuDniConsulta(nuDniConsulta);
        request.setNuRucUsuario(nuRucUsuario);

        return (ResultadoConsulta) getWebServiceTemplate()
                .marshalSendAndReceive(ENDPOINT_URL, request,
                        new SoapActionCallback("http://endpoint.wsconsultadni.reniec.gob.pe/SRELServiceService/consultarCertificadoRequest"));
    }

    public ResultadoActualizacionCredencial actualizarCredencial(String credencialAnterior, String credencialNueva,
                                                               String nuDni, String nuRuc) {
        PeticionActualizarCredencial request = new PeticionActualizarCredencial();
        request.setCredencialAnterior(credencialAnterior);
        request.setCredencialNueva(credencialNueva);
        request.setNuDni(nuDni);
        request.setNuRuc(nuRuc);

        return (ResultadoActualizacionCredencial) getWebServiceTemplate()
                .marshalSendAndReceive(ENDPOINT_URL, request,
                        new SoapActionCallback("http://endpoint.wsconsultadni.reniec.gob.pe/SRELServiceService/actualizarCredencialRequest"));
    }
}