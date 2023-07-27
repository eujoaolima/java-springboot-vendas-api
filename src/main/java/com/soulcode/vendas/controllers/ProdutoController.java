package com.soulcode.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soulcode.vendas.models.Produto;
import com.soulcode.vendas.repositories.ProdutoRepository;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    // @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    // public Produto save() {
    //     Produto produto = new Produto();
    //     produto.setCodigo("123456");
    //     produto.setDescricao("Batata");
    //     produto.setPreco(6F);
    //     produto.setUnidadeMedida("L");
    //     produto.setGrupo("Vegetais");
    //     produto = this.produtoRepository.save(produto);
    //     return produto;
    // }

    @RequestMapping(value="/produtos", method = RequestMethod.GET)
    public List<Produto> findAll() {
        List<Produto> produtos = this.produtoRepository.findAll();
        return produtos;
    }

}
