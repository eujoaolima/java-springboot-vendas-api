package com.soulcode.vendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soulcode.vendas.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT * FROM item WHERE venda_id = ?", nativeQuery = true)
    public List<Item> findByIdVenda(Long idVenda);
}
