package com.example.demo.service;

import com.example.demo.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService implements ClienteServiceInterface {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + id));
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        Cliente clienteOriginal = getClienteById(cliente.getId());
        clienteOriginal.setCpf(cliente.getCpf());
        clienteOriginal.setNome(cliente.getNome());
        clienteOriginal.setEmail(cliente.getEmail());
        clienteOriginal.setTelefone(cliente.getTelefone());
        clienteOriginal.setEndereco(cliente.getEndereco());
        clienteOriginal.setCidade(cliente.getCidade());
        clienteOriginal.setEstado(cliente.getEstado());
        clienteOriginal.setCep(cliente.getCep());
        return clienteRepository.save(clienteOriginal);
    }

    @Override
    public void deleteClienteById(Long id) {
        clienteRepository.deleteById(id);
    }

}
