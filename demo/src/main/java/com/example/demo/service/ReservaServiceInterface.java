package com.example.demo.service;

import com.example.demo.model.Reserva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservaServiceInterface {

    List<Reserva> getAllReservas();

    Reserva getReservaById(Long id);

    Reserva createReserva(Reserva reserva);

    Reserva updateReserva(Reserva reserva);

    void deleteReservaById(Long id);

    List<Reserva> findReservasByData(LocalDate data);

    List<Reserva> findReservasByHora(LocalTime hora);

    List<Reserva> findReservasByClienteNome(String clienteNome);

    List<Reserva> findReservasByDataAndHora(LocalDate data, LocalTime hora);

    List<Reserva> findReservasByDataAndClienteNome(LocalDate data, String clienteNome);

    List<Reserva> findReservasByHoraAndClienteNome(LocalTime hora, String clienteNome);

    List<Reserva> findReservasByDataAndHoraAndClienteNome(LocalDate data, LocalTime hora, String clienteNome);

}

