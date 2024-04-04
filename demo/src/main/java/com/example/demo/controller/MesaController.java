package com.example.demo.controller;

import com.example.demo.model.Mesa;
import com.example.demo.service.MesaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.MesaService;


import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {


    @Autowired
    private MesaServiceInterface mesaService;

    @GetMapping
    public List<Mesa> listar() {
        return mesaService.listar();
    }

    @PostMapping
    public Mesa criar(@RequestBody Mesa mesa) {
        return mesaService.criar(mesa);
    }

    @GetMapping("/{id}")
    public Mesa buscarPorId(@PathVariable Long id) {
        return mesaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Mesa atualizar(@RequestBody Mesa mesa, @PathVariable Long id) {
        return mesaService.atualizar(mesa, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletar(@PathVariable Long id) {
        if (mesaService.deletar(id)) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

