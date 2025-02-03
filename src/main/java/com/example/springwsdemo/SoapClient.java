package com.example.springwsdemo;

import com.example.springwsdemo.gen.request.ConsultaArg;
import com.example.springwsdemo.gen.request.Consultar;
import com.example.springwsdemo.gen.request.RequestBody;
import com.example.springwsdemo.gen.request.RequestEnvelope;
import com.example.springwsdemo.gen.response.ResponseEnvelope;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SoapClient {
    public static void main(String[] args) {
        try {
            // SOAP Endpoint and Request Body
            String endpointUrl = "http://65.1.93.129/consultadnie/ConsultaDniService";
            // Send SOAP request and get response
            String sampleSoapRequest = buildSoapRequest();
            System.out.println("sample soap request: " + sampleSoapRequest);
            String soapResponse = sendSOAPRequest(endpointUrl, sampleSoapRequest);

            JAXBContext jaxbContext = JAXBContext.newInstance(ResponseEnvelope.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            ResponseEnvelope response = (ResponseEnvelope) unmarshaller.unmarshal(new StringReader(soapResponse));

            System.out.println(response.getResponseBody().getConsultarResponse().getResponseReturn().getCoResultado());
            System.out.println(response.getResponseBody().getConsultarResponse().getResponseReturn().getDeResultado());
            System.out.println(response.getResponseBody().getConsultarResponse().getResponseReturn().getDatosPersona().getDni());
            System.out.println(response.getResponseBody().getConsultarResponse().getResponseReturn().getDatosPersona().getPrenombres());
            System.out.println(response.getResponseBody().getConsultarResponse().getResponseReturn().getDatosPersona().getGenero());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String sendSOAPRequest(String endpointUrl, String soapRequest) throws Exception {
        URL url = new URL(endpointUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        connection.setDoOutput(true);
        // Send SOAP request
        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(soapRequest.getBytes());
            outputStream.flush();
        }
        // Read the response
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            return new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } else {
            throw new RuntimeException("HTTP error code: " + connection.getResponseCode());
        }
    }

    private static String buildSoapRequest() throws Exception {
        // Create the object structure
        ConsultaArg arg = new ConsultaArg();
        arg.setNuDniConsulta("06794000");
        arg.setNuDniUsuario("06794000");
        arg.setNuRucUsuario("20295613620");
        arg.setPassword("06794000");

        Consultar consultar = new Consultar();
        consultar.setArg0(arg);

        RequestBody body = new RequestBody();
        body.setConsultar(consultar);

        RequestEnvelope envelope = new RequestEnvelope();
        envelope.setBody(body);

        // Convert to XML
        JAXBContext context = JAXBContext.newInstance(RequestEnvelope.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter sw = new StringWriter();
        marshaller.marshal(envelope, sw);
        return sw.toString();
    }
}