package com.example.demo.service;

import com.example.demo.model.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.MesaRepository;

import java.util.List;

@Service
public class MesaService implements MesaServiceInterface {

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public List<Mesa> listar() {
        return mesaRepository.findAll();
    }

    @Override
    public Mesa criar(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    @Override
    public Mesa buscarPorId(Long id) {
        return mesaRepository.findById(id).orElseThrow(() -> new RuntimeException("Mesa não encontrada com o ID: " + id));
    }


    @Override
    public Mesa atualizar(Mesa mesa, Long id) {
        Mesa mesaEncontrada = mesaRepository.findById(id).orElseThrow(() -> new RuntimeException("Mesa não encontrada com o ID: " + id));
        mesaEncontrada.setNumero(mesa.getNumero());
        mesaEncontrada.setCapacidade(mesa.getCapacidade());
        mesaEncontrada.setDisponivel(mesa.isDisponivel());
        return mesaRepository.save(mesaEncontrada);
    }

    @Override
    public boolean deletar(Long id) {
        try {
            mesaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
