package com.soulcode.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.vendas.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
