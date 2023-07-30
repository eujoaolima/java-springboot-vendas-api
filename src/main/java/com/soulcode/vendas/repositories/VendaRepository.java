package com.soulcode.vendas.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.soulcode.vendas.models.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
