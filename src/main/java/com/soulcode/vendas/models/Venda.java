package com.soulcode.vendas.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dataRegistro;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private List<Item> itens;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataRegistro() {
        return this.dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItens() {
        return this.itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Venda() {
    }

    public Venda(Long id) {
        this.id = id;
    }
}
