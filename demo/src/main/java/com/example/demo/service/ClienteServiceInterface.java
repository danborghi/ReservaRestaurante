package com.example.demo.service;

import com.example.demo.model.Cliente;

import java.util.List;

public interface ClienteServiceInterface {

    List<Cliente> getAllClientes();

    Cliente getClienteById(Long id);

    Cliente createCliente(Cliente cliente);

    Cliente updateCliente(Cliente cliente);

    void deleteClienteById(Long id);

}