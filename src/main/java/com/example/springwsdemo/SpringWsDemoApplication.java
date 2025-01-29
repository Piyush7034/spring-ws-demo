package com.example.springwsdemo;

import com.example.springwsdemo.gen.*;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.handler.Handler;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@SpringBootApplication
public class SpringWsDemoApplication {

    public static void main(String[] args) throws MalformedURLException {
//        URL wsdlURL = new URL("http://65.1.93.129/");

        SimpleConsultaDniService service = new SimpleConsultaDniService();
        SRELServiceService port = service.getSRELServiceServicePort();

        BindingProvider bindingProvider = (BindingProvider) port;
//        bindingProvider.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
//        bindingProvider.getRequestContext().put(BindingProvider.SOAPACTION_URI_PROPERTY, "http://endpoint.wsconsultadni.reniec.gob.pe/SRELServiceService/consultarRequest");

        List<Handler> handlerChain = new ArrayList<>();
        handlerChain.add(new SOAPActionHandler());
        bindingProvider.getBinding().setHandlerChain(handlerChain);

        System.out.println("req ctx: " + bindingProvider.getRequestContext());

        consultarExample(port);
    }

    private static void consultarExample(SRELServiceService port) {
        // Prepare request
        PeticionConsulta request = new PeticionConsulta();
        request.setNuDniConsulta("06794000");       // DNI to query
        request.setNuDniUsuario("06794000");        // Your user DNI
        request.setNuRucUsuario("20295613620");     // Your RUC
        request.setPassword("06794000");       // Your password

        // Call service
        ResultadoConsulta response = port.consultar(request);

        // Handle response
        System.out.println("Code: " + response.getCoResultado());
        System.out.println("Message: " + response.getDeResultado());

//        DatosPersona person = response.getDatosPersona();
//        if (person != null) {
//            System.out.println("Name: " + person.getPrenombres() + " " +
//                    person.getPrimerApellido());
//        }
    }
}

