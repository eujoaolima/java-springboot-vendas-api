package com.soulcode.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soulcode.vendas.models.Produto;
import com.soulcode.vendas.services.ProdutoService;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public Produto save(@RequestBody Produto produto) {
        return this.produtoService.save(produto);
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public List<Produto> findAll() {
        return this.produtoService.findAll();
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public Produto findById(@PathVariable Long id) {
        return this.produtoService.findById(id);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
    public Produto deleteById(@PathVariable Long id) {
        return this.produtoService.deleteById(id);
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.DELETE)
    public List<Produto> deleteAll() {
        return this.produtoService.deleteAll();
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.PUT)
    public Produto updateById(@PathVariable Long id, @RequestBody Produto produto) {
        return this.produtoService.updateById(id, produto);
    }
}
