package com.soulcode.vendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.soulcode.vendas.models.Produto;
import com.soulcode.vendas.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        produto = this.produtoRepository.save(produto);
        return produto;
    }

    public List<Produto> findAll() {
        List<Produto> produtos = this.produtoRepository.findAll();
        return produtos;
    }

    public Produto findById(Long id) {
        Optional<Produto> resultado = this.produtoRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException("O produto não foi encontrado :(");
        } else {
            return resultado.get();
        }
    }

    public Produto deleteById(@PathVariable Long id) {
        Produto produto = findById(id);
        if (produto == null) {
            throw new RuntimeException("O produto não foi encontrado :(");
        } else {
            this.produtoRepository.deleteById(id);
            return produto;
        }
    }

    public List<Produto> deleteAll() {
        List<Produto> produto = findAll();
        this.produtoRepository.deleteAll();
        return produto;
    }

    public Produto updateById(@PathVariable Long id, @RequestBody Produto produto) {
        this.findById(id);
        if (produto == null) {
            throw new RuntimeException("O produto não foi encontrado :(");
        } else {
            produto.setId(id);
            produto = this.produtoRepository.save(produto);
            return produto;
        }
    }
}
