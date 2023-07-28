package com.soulcode.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soulcode.vendas.models.Produto;
import com.soulcode.vendas.models.dtos.ProdutoDTO;
import com.soulcode.vendas.services.ProdutoService;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public ProdutoDTO save(@RequestBody ProdutoDTO dto) {
        return this.produtoService.save(dto);
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public List<ProdutoDTO> findAll() {
        return this.produtoService.findAll();
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public ProdutoDTO findById(@PathVariable Long id) {
        return this.produtoService.findById(id);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
    public ProdutoDTO deleteById(@PathVariable Long id) {
        return this.produtoService.deleteById(id);
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.DELETE)
    public List<ProdutoDTO> deleteAll() {
        return this.produtoService.deleteAll();
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.PUT)
    public ProdutoDTO updateById(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
        return this.produtoService.updateById(id, dto);
    }
}
