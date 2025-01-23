package com.example.springwsdemo;

import com.example.springwsdemo.gen.ResultadoActualizacionCredencial;
import com.example.springwsdemo.gen.ResultadoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dni")
public class ConsultaDniController {

    private final ConsultaDniService consultaDniService;

    @Autowired
    public ConsultaDniController(ConsultaDniService consultaDniService) {
        this.consultaDniService = consultaDniService;
    }

    @GetMapping("/consultar")
    public ResponseEntity<ResultadoConsulta> consultarDni(
            @RequestParam String nuDniConsulta,
            @RequestParam String nuDniUsuario,
            @RequestParam String nuRucUsuario,
            @RequestParam String password) {

        ResultadoConsulta resultado = consultaDniService.consultarDni(
                nuDniConsulta, nuDniUsuario, nuRucUsuario, password);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/certificado")
    public ResponseEntity<ResultadoConsulta> consultarCertificado(
            @RequestParam String accessToken,
            @RequestParam String nuDniConsulta,
            @RequestParam String nuRucUsuario) {

        ResultadoConsulta resultado = consultaDniService.consultarCertificado(
                accessToken, nuDniConsulta, nuRucUsuario);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/actualizar-credencial")
    public ResponseEntity<ResultadoActualizacionCredencial> actualizarCredencial(
            @RequestParam String credencialAnterior,
            @RequestParam String credencialNueva,
            @RequestParam String nuDni,
            @RequestParam String nuRuc) {

        ResultadoActualizacionCredencial resultado = consultaDniService.actualizarCredencial(
                credencialAnterior, credencialNueva, nuDni, nuRuc);
        return ResponseEntity.ok(resultado);
    }
}