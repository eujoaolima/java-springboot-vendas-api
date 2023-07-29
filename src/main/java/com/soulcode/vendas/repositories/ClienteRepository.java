package com.soulcode.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soulcode.vendas.models.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
