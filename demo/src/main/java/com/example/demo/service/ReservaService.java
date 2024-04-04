package com.example.demo.service;

import com.example.demo.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ReservaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ReservaService implements ReservaServiceInterface {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada com o ID: " + id));
    }

    @Override
    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva updateReserva(Reserva reserva) {
        Reserva reservaOriginal = getReservaById(reserva.getId());
        reservaOriginal.setData(reserva.getData());
        reservaOriginal.setHora(reserva.getHora());
        reservaOriginal.setNumeroPessoas(reserva.getNumeroPessoas());
        reservaOriginal.setCliente(reserva.getCliente());
        reservaOriginal.setMesa(reserva.getMesa());
        reservaOriginal.setStatus(reserva.getStatus());
        reservaOriginal.setObservacao(reserva.getObservacao());
        return reservaRepository.save(reservaOriginal);
    }

    @Override
    public void deleteReservaById(Long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public List<Reserva> findReservasByData(LocalDate data) {
        return reservaRepository.findAllByData(data);
    }

    @Override
    public List<Reserva> findReservasByHora(LocalTime hora) {
        return reservaRepository.findAllByHora(hora);
    }

    @Override
    public List<Reserva> findReservasByClienteNome(String clienteNome) {
        return reservaRepository.findAllByClienteNome(clienteNome);
    }

    @Override
    public List<Reserva> findReservasByDataAndHora(LocalDate data, LocalTime hora) {
        return reservaRepository.findAllByDataAndHora(data, hora);
    }

    @Override
    public List<Reserva> findReservasByDataAndClienteNome(LocalDate data, String clienteNome) {
        return reservaRepository.findAllByDataAndClienteNome(data, clienteNome);
    }

    @Override
    public List<Reserva> findReservasByHoraAndClienteNome(LocalTime hora, String clienteNome) {
        return reservaRepository.findAllByHoraAndClienteNome(hora, clienteNome);
    }

    @Override
    public List<Reserva> findReservasByDataAndHoraAndClienteNome(LocalDate data, LocalTime hora, String clienteNome) {
        return reservaRepository.findAllByDataAndHoraAndClienteNome(data, hora, clienteNome);
    }

}

