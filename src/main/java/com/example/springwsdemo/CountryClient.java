package com.example.springwsdemo;


import com.example.springwsdemo.gen.ListOfCountryNamesByName;
import com.example.springwsdemo.gen.ListOfCountryNamesByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class CountryClient {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public ListOfCountryNamesByNameResponse getListOfCountriesByName() {
        ListOfCountryNamesByName request = new ListOfCountryNamesByName();
        ListOfCountryNamesByNameResponse response = (ListOfCountryNamesByNameResponse) webServiceTemplate.marshalSendAndReceive(request);

        return response;
    }

}