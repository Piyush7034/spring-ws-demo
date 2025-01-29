package com.example.springwsdemo;

import com.example.springwsdemo.gen.ResultadoConsulta;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.SOAPBody;
import jakarta.xml.soap.SOAPMessage;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
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
            String soapRequest = """
                    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:end="http://endpoint.wsconsultadni.reniec.gob.pe/">
                       <soapenv:Header/>
                       <soapenv:Body>
                           <end:consultar>
                               <arg0>
                                   <!--Optional:-->
                                   <nuDniConsulta>06794000</nuDniConsulta>
                                   <!--Optional:-->
                                   <nuDniUsuario>06794000</nuDniUsuario>
                                   <!--Optional:-->
                                   <nuRucUsuario>20295613620</nuRucUsuario>
                                   <!--Optional:-->
                                   <password>06794000</password>
                               </arg0>
                           </end:consultar>
                       </soapenv:Body>
                   </soapenv:Envelope>
                """;
            // Send SOAP request and get response
            String soapResponse = sendSOAPRequest(endpointUrl, soapRequest);
            // Extract the SOAP Body
            String responseBody = extractSOAPBody(soapResponse);

            System.out.println("response body:" + responseBody);
            // Unmarshal the response body
//            JAXBContext jaxbContext = JAXBContext.newInstance(ResultadoConsulta.class);
//            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//            ResultadoConsulta response = (ResultadoConsulta) unmarshaller.unmarshal(new StringReader(responseBody));
//            // Print the unmarshalled result
//            System.out.println("Response Result: " + response.getDatosPersona());
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
    private static String extractSOAPBody(String soapMessage) throws Exception {
        // Parse the SOAP response
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage(null, new ByteArrayInputStream(soapMessage.getBytes(StandardCharsets.UTF_8)));
        SOAPBody body = message.getSOAPBody();
        // Return the content of the SOAP body as a string
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(body), new StreamResult(writer));
        return writer.toString();
    }
}