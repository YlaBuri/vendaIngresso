package com.example.vendaingresso.controller;


import com.example.vendaingresso.dto.ClienteRequestDto;
import com.example.vendaingresso.dto.ClienteResponseDto;
import com.example.vendaingresso.model.Cliente;
import com.example.vendaingresso.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("")
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listar(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok().body(new ClienteResponseDto(cliente.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/")
    public ResponseEntity<ClienteResponseDto> inserir(@RequestBody @Valid ClienteRequestDto clienteRequestDto){
        try {
            return ResponseEntity.ok().body(new ClienteResponseDto(clienteService.inserir(clienteRequestDto)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
