package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mesas")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private Integer capacidade;

    @Column(nullable = false)
    private String localizacao;

    @Column(nullable = false)
    private Boolean disponivel;

    public Mesa() {
    }

    public Mesa(Integer numero, Integer capacidade, String localizacao, Boolean disponivel) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
        this.disponivel = disponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

}
