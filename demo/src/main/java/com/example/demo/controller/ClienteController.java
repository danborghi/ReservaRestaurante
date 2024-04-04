package com.example.demo.controller;

import com.example.demo.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.getClienteById(id);
        return ResponseEntity.ok(cliente);
    }


    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.createCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            Cliente clienteAtualizado = clienteService.updateCliente(cliente);
            return ResponseEntity.ok(clienteAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable Long id) {
        clienteService.deleteClienteById(id);
        return ResponseEntity.noContent().build();
    }

}
