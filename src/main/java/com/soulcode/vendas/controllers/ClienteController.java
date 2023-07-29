package com.soulcode.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soulcode.vendas.models.dtos.ClienteDTO;
import com.soulcode.vendas.models.dtos.ProdutoDTO;
import com.soulcode.vendas.services.ClienteService;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    // Buscar todos os clientes
    @RequestMapping(value="/clientes", method=RequestMethod.GET)
    public List<ClienteDTO> findAll() {
        return this.clienteService.findAll();
    }

    // Buscar cliente por ID
    @RequestMapping(value="/clientes/{id}", method=RequestMethod.GET)
    public ClienteDTO findById(@PathVariable Long id) {
        return this.clienteService.findById(id);
    }

    // Criar um novo cliente
    @RequestMapping(value="/clientes", method=RequestMethod.POST)
    public ClienteDTO save(@RequestBody ClienteDTO dto) {
        return this.clienteService.save(dto);
    }

    // Atualizar informações do cliente
    @RequestMapping(value="/clientes/{id}", method=RequestMethod.PUT)
    public ClienteDTO updateById(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return this.clienteService.updateByID(id, dto);
    }

    // Deletar cliente por ID
    @RequestMapping(value="/clientes/{id}", method=RequestMethod.GET)
    public ClienteDTO deleteById(@PathVariable Long id) {
        return this.clienteService.deleteById(id);
    }

    // Deletar todos os clientes
    @RequestMapping(value = "/clientes", method = RequestMethod.DELETE)
    public List<ClienteDTO> deleteAll() {
        return this.clienteService.deleteAll();
    }


}
