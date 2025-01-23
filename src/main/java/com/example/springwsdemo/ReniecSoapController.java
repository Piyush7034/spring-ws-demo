package com.example.springwsdemo;

import com.example.springwsdemo.gen.DatosPersona;
import com.example.springwsdemo.gen.ResultadoActualizacionCredencial;
import com.example.springwsdemo.gen.ResultadoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReniecSoapController {

    @Autowired
    private ReniecSoapClient reniecSoapClient;

    @GetMapping(value = "/reniec-consult/consultar-dni")
    public String getConsultarDniResponse() {
        ResultadoConsulta resultado = reniecSoapClient.consultarDni(
                "12345678",  // DNI to consult
                "12345678",  // User DNI
                "12345678910", // RUC
                "password123"  // Password
        );

        // To check the results
        if (resultado.getCoResultado().equals("0")) {  // Assuming 0 is success
            DatosPersona persona = resultado.getDatosPersona();
            System.out.println("DNI: " + persona.getDni());
            System.out.println("Nombres: " + persona.getPrenombres());
            System.out.println("Apellido Paterno: " + persona.getPrimerApellido());
            System.out.println("Apellido Materno: " + persona.getSegundoApellido());
        } else {
            System.out.println("Error: " + resultado.getDeResultado());
        }

        return "reniec conulta dni response success";
    }

    @GetMapping(value = "/reniec-consult/consultar-certificado")
    public String getConsultarCertificado() {
        ResultadoConsulta resultado = reniecSoapClient.consultarCertificado(
                "access_token",
                "12345678",  // DNI to consult
                "12345678910" // RUC
        );

        // To check the results
        if (resultado.getCoResultado().equals("0")) {  // Assuming 0 is success
            DatosPersona persona = resultado.getDatosPersona();
            System.out.println("DNI: " + persona.getDni());
            System.out.println("Nombres: " + persona.getPrenombres());
            System.out.println("Apellido Paterno: " + persona.getPrimerApellido());
            System.out.println("Apellido Materno: " + persona.getSegundoApellido());
        } else {
            System.out.println("Error: " + resultado.getDeResultado());
        }

        return "reniec conulta certificate response success";
    }

    @GetMapping(value = "/reniec-consult/actualizar-credencial")
    public String getActualizarCredencial() {
        ResultadoActualizacionCredencial resultado = reniecSoapClient.actualizarCredencial(
                "password123",
                "password1234",  // DNI to consult
                "12345678",
                "12345678910"// RUC
        );

        // To check the results
        System.out.println("Error: " + resultado.getDeResultado());

        return "reniec conulta certificate response success";
    }
}
