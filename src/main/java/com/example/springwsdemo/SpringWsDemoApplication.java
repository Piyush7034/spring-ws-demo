package com.example.springwsdemo;

import com.example.springwsdemo.gen.DatosPersona;
import com.example.springwsdemo.gen.ResultadoConsulta;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringWsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWsDemoApplication.class, args);
    }
}
