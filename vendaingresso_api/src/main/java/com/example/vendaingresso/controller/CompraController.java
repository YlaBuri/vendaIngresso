package com.example.vendaingresso.controller;

import com.example.vendaingresso.dto.ClienteRequestDto;
import com.example.vendaingresso.dto.ClienteResponseDto;
import com.example.vendaingresso.dto.CompraRequestDto;
import com.example.vendaingresso.dto.CompraResponseDto;
import com.example.vendaingresso.model.Compra;
import com.example.vendaingresso.service.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/compra")
public class CompraController {

    CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Compra>> listar(){
        List<Compra> compras = compraService.findAll();
        return ResponseEntity.ok().body(compras);

    }

    @PostMapping("/")
    public ResponseEntity<CompraResponseDto> inserir(@RequestBody @Valid CompraRequestDto compraRequestDto){
        try {
            return ResponseEntity.ok().body(new CompraResponseDto(compraService.inserir(compraRequestDto)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
