package com.soulcode.vendas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.soulcode.vendas.models.Produto;
import com.soulcode.vendas.models.dtos.ProdutoDTO;
import com.soulcode.vendas.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO save(ProdutoDTO dto) {
        Produto produto = ProdutoDTO.convert(dto);
        produto = this.produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    public List<ProdutoDTO> findAll() {
        List<Produto> produtos = this.produtoRepository.findAll();
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    public ProdutoDTO findById(Long id) {
        Optional<Produto> resultado = this.produtoRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException("O produto não foi encontrado :(");
        } else {
            return new ProdutoDTO(resultado.get());
        }
    }

    public ProdutoDTO deleteById(@PathVariable Long id) {
        ProdutoDTO dto = findById(id);
        if (dto == null) {
            throw new RuntimeException("O produto não foi encontrado :(");
        } else {
            this.produtoRepository.deleteById(id);
            return dto;
        }
    }

    public List<ProdutoDTO> deleteAll() {
        List<ProdutoDTO> produto = findAll();
        this.produtoRepository.deleteAll();
        return produto;
    }

    public ProdutoDTO updateById(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
        this.findById(id);
        Produto produto = ProdutoDTO.convert(dto);
        if (dto == null) {
            throw new RuntimeException("O produto não foi encontrado :(");
        } else {
            produto.setId(id);
            produto = this.produtoRepository.save(produto);
            return new ProdutoDTO(produto);
        }
    }
}
