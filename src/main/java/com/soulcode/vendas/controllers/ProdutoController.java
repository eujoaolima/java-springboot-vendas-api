package com.soulcode.vendas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soulcode.vendas.models.Produto;
import com.soulcode.vendas.repositories.ProdutoRepository;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public Produto save(@RequestBody Produto produto) {
        produto = this.produtoRepository.save(produto);
        return produto;
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public List<Produto> findAll() {
        List<Produto> produtos = this.produtoRepository.findAll();
        return produtos;
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public Produto findById(@PathVariable Long id) {
        Optional<Produto> resultado = this.produtoRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException("O produto não foi encontrado :(");
        } else {
            return resultado.get();
        }
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Produto> deleteById(@PathVariable Long id) {
        Produto produto = findById(id);
        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.produtoRepository.deleteById(id);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.DELETE)
    public ResponseEntity<List<Produto>> deleteAll() {
        List<Produto> produto = findAll();
        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.produtoRepository.deleteAll();
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Produto> updateById(@PathVariable Long id, @RequestBody Produto produto) {
        this.findById(id);
        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            produto.setId(id);
            produto = this.produtoRepository.save(produto);
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }
    }
}
