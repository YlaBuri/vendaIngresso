package com.example.vendaingresso.controller;

import com.example.vendaingresso.model.Ingresso;
import com.example.vendaingresso.service.IngressoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ingresso")
public class IngressoController {

    private IngressoService ingressoService;

    public IngressoController(IngressoService ingressoService) {
        this.ingressoService = ingressoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Ingresso>> findAll(){
        List<Ingresso> ingressos = ingressoService.findAll();
        return ResponseEntity.ok().body(ingressos);
    }


}
