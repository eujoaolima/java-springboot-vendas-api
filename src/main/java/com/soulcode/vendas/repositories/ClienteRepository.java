package com.soulcode.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulcode.vendas.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
