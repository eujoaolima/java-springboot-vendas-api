package com.soulcode.vendas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soulcode.vendas.models.Cliente;
import com.soulcode.vendas.models.dtos.ClienteDTO;
import com.soulcode.vendas.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    // Criar cliente
    @RequestMapping(value = "/clientes", method = RequestMethod.POST)
    public ClienteDTO save(@RequestBody ClienteDTO dto) {
        Cliente cliente = ClienteDTO.convert(dto);
        cliente = this.clienteRepository.save(cliente);
        return new ClienteDTO(cliente);
    }

    // Buscar cliente por ID
    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
    public ClienteDTO findById(@PathVariable Long id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new RuntimeException("O cliente não foi encontrado :(");
        } else {
            return new ClienteDTO(cliente.get());
        }
    }

    // Buscar todos os clientes
    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public List<ClienteDTO> findAll() {
        List<Cliente> cliente = this.clienteRepository.findAll();
        return cliente.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    // Atualizar cliente por ID
    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.PUT)
    public ClienteDTO updateById(Long id, ClienteDTO dto) {
        this.findById(id);
        Cliente cliente = ClienteDTO.convert(dto);
        this.clienteRepository.save(cliente);
        cliente.setId(id);
        return new ClienteDTO(cliente);
    }

    // Deletar cliente por ID
    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
    public ClienteDTO deleteById(Long id) {
        ClienteDTO dto = findById(id);
        this.clienteRepository.deleteById(id);
        return dto;
    }

    // Deletar todos os clientes
    @RequestMapping(value = "/clientes", method = RequestMethod.DELETE)
    public List<ClienteDTO> deleteAll() {
        List<ClienteDTO> cliente = findAll();
        this.clienteRepository.deleteAll();
        return cliente;
    }
}
