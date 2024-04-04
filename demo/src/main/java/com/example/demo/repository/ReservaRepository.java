package com.example.demo.repository;

import com.example.demo.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findAllByData(LocalDate data);

    List<Reserva> findAllByHora(LocalTime hora);

    List<Reserva> findAllByClienteNome(String clienteNome);

    List<Reserva> findAllByDataAndHora(LocalDate data, LocalTime hora);

    List<Reserva> findAllByDataAndClienteNome(LocalDate data, String clienteNome);

    List<Reserva> findAllByHoraAndClienteNome(LocalTime hora, String clienteNome);

    List<Reserva> findAllByDataAndHoraAndClienteNome(LocalDate data, LocalTime hora, String clienteNome);

}
