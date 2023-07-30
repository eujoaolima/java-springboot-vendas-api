package com.soulcode.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soulcode.vendas.models.dtos.VendaDTO;
import com.soulcode.vendas.services.VendaService;

@RestController
public class VendaController {
    @Autowired
    private VendaService vendaService;

    // Criar venda
    @PostMapping("/vendas")
    public VendaDTO save(@RequestBody VendaDTO dto) {
        return this.vendaService.save(dto);
    }

    // Buscar venda por Id
    @GetMapping("/vendas/{id}")
    public VendaDTO findById(@PathVariable Long id) {
        return this.vendaService.findById(id);
    }

    // Buscar todas as vendas
    @GetMapping("/vendas")
    public List<VendaDTO> findAll() {
        return this.vendaService.findAll();
    }

    // // Editar venda
    // @PutMapping("/vendas/{id}")
    // public VendaDTO updateById() {
    //     return this.vendaService.updateById();
    // }

    // // Deletar venda por Id
    // @DeleteMapping("/vendas/{id}")
    // public VendaDTO deleteById() {
    //     return this.vendaService.deleteById();
    // }

    // // Deletar todas as vendas
    // @DeleteMapping("/vendas/{id}")
    // public VendaDTO deleteAll() {
    //     return this.vendaService.deleteAll();
    // }
}
