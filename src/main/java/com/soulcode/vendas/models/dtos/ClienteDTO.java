package com.soulcode.vendas.models.dtos;

import com.soulcode.vendas.models.Cliente;

public class ClienteDTO {

    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String dataNascimento;

    private String telefone;

    private String logradouro;

    private String numeroEndereco;

    private String cidade;

    private String estado;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id) {
        this.id = id;
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.telefone = cliente.getTelefone();
        this.logradouro = cliente.getLogradouro();
        this.numeroEndereco = cliente.getNumeroEndereco();
        this.cidade = cliente.getCidade();
        this.estado = cliente.getEstado();
    }

    public static Cliente convert(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        cliente.setCidade(clienteDTO.getCidade());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setLogradouro(clienteDTO.getLogradouro());
        cliente.setEstado(clienteDTO.getEstado());
        cliente.setNumeroEndereco(clienteDTO.getNumeroEndereco());
        return cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroEndereco() {
        return this.numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
