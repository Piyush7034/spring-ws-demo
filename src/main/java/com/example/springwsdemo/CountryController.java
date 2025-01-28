package com.example.springwsdemo;

import com.example.springwsdemo.gen.ListOfCountryNamesByNameResponse;
import com.example.springwsdemo.gen.TCountryCodeAndName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/soap-data")
public class CountryController {

    @Autowired
    private CountryClient countryClient;

    @GetMapping(value = "/country-info")
    public ResponseEntity<List<TCountryCodeAndName>> getCountryResponse() {
        ListOfCountryNamesByNameResponse response = countryClient.getListOfCountriesByName();

        // To check the results
        System.out.println("response" + response.getListOfCountryNamesByNameResult().getTCountryCodeAndName());
        List<TCountryCodeAndName> tCountryCodeAndNameList = response.getListOfCountryNamesByNameResult().getTCountryCodeAndName();


        return ResponseEntity.ok(tCountryCodeAndNameList);
    }
}