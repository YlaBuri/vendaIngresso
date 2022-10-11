package com.example.vendaingresso.controller;

import com.example.vendaingresso.model.Poltrona;
import com.example.vendaingresso.service.PoltronaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/poltrona")
public class PoltronaController {

    private PoltronaService poltronaService;

    public PoltronaController(PoltronaService poltronaService) {
        this.poltronaService = poltronaService;
    }

    @GetMapping("/")
    private ResponseEntity<List<Poltrona>> findAll(){
        List<Poltrona> poltronas = poltronaService.findAll();
        return ResponseEntity.ok().body(poltronas);
    }

    @GetMapping("/evento/{idEvento}")
    private ResponseEntity<List<Poltrona>> buscarLivres(@PathVariable Long idEvento){
        List<Poltrona> poltronas = poltronaService.buscarLivres(idEvento);
        return ResponseEntity.ok().body(poltronas);
    }
}
