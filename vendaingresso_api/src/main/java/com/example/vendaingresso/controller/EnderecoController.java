package com.example.vendaingresso.controller;


import com.example.vendaingresso.model.Endereco;
import com.example.vendaingresso.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
         this.enderecoService =  enderecoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Endereco>> listar() {
        List<Endereco> enderecos = enderecoService.findAll();
        return ResponseEntity.ok().body(enderecos);
    }
    
}
