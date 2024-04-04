package com.example.demo.service;

import com.example.demo.model.Mesa;

import java.util.List;

public interface MesaServiceInterface {

    List<Mesa> listar();

    Mesa criar(Mesa mesa);

    Mesa buscarPorId(Long id);


    Mesa atualizar(Mesa mesa, Long id);

    boolean deletar(Long id);

}
