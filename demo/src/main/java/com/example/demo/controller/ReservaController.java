package com.example.demo.controller;

import com.example.demo.model.Reserva;
import com.example.demo.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
        Reserva reserva = reservaService.getReservaById(id);
        return ResponseEntity.ok(reserva);
    }


    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.createReserva(reserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        try {
            Reserva reservaAtualizada = reservaService.updateReserva(reserva);
            return ResponseEntity.ok(reservaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservaById(@PathVariable Long id) {
        reservaService.deleteReservaById(id);
        return ResponseEntity.noContent().build();
    }

    // Métodos de busca por data, hora e cliente:

    @GetMapping("/por-data/{data}")
    public ResponseEntity<List<Reserva>> findReservasByData(@PathVariable LocalDate data) {
        return ResponseEntity.ok(reservaService.findReservasByData(data));
    }

    @GetMapping("/por-hora/{hora}")
    public ResponseEntity<List<Reserva>> findReservasByHora(@PathVariable LocalTime hora) {
        return ResponseEntity.ok(reservaService.findReservasByHora(hora));
    }

    @GetMapping("/por-cliente/{clienteNome}")
    public ResponseEntity<List<Reserva>> findReservasByClienteNome(@PathVariable String clienteNome) {
        return ResponseEntity.ok(reservaService.findReservasByClienteNome(clienteNome));
    }

    @GetMapping("/por-data-e-hora/{data}/{hora}")
    public ResponseEntity<List<Reserva>> findReservasByDataAndHora(@PathVariable LocalDate data, @PathVariable LocalTime hora) {
        return ResponseEntity.ok(reservaService.findReservasByDataAndHora(data, hora));
    }

    @GetMapping("/por-data-e-cliente/{data}/{clienteNome}")
    public ResponseEntity<List<Reserva>> findReservasByDataAndClienteNome(@PathVariable LocalDate data, @PathVariable String clienteNome) {
        return ResponseEntity.ok(reservaService.findReservasByDataAndClienteNome(data, clienteNome));
    }

    @GetMapping("/por-hora-e-cliente/{hora}/{clienteNome}")
    public ResponseEntity<List<Reserva>> findReservasByHoraAndClienteNome(@PathVariable LocalTime hora, @PathVariable String clienteNome) {
        return ResponseEntity.ok(reservaService.findReservasByHoraAndClienteNome(hora, clienteNome));
    }

    @GetMapping("/por-data-hora-e-cliente/{data}/{hora}/{clienteNome}")
    public ResponseEntity<List<Reserva>> findReservasByDataAndHoraAndClienteNome(@PathVariable LocalDate data, @PathVariable LocalTime hora, @PathVariable String clienteNome) {
        return ResponseEntity.ok(reservaService.findReservasByDataAndHoraAndClienteNome(data, hora, clienteNome));
    }
}

