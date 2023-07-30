package com.soulcode.vendas.models.dtos;

import com.soulcode.vendas.models.Item;
import com.soulcode.vendas.models.Produto;
import com.soulcode.vendas.models.Venda;

import jakarta.validation.constraints.NotNull;

public class ItemDTO {
    private Long id;

    @NotNull(message="O valor parcial deve ser preenchido")
    private Float valorParcial;

    @NotNull(message="A quantidade deve ser preenchida")
    private Integer quantidade;

    private Long idVenda;

    @NotNull(message="O ID do produto deve ser preenchido")
    private Long idProduto;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValorParcial() {
        return this.valorParcial;
    }

    public void setValorParcial(Float valorParcial) {
        this.valorParcial = valorParcial;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdVenda() {
        return this.idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Long getIdProduto() {
        return this.idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public ItemDTO() {
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.valorParcial = item.getValorParcial();
        this.quantidade = item.getQuantidade();
        this.idVenda = item.getVenda().getId();
        this.idProduto = item.getProduto().getId();
    }

    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setValorParcial(itemDTO.getValorParcial());
        item.setQuantidade(itemDTO.getQuantidade());
        item.setVenda(new Venda(itemDTO.getIdVenda()));
        item.setProduto(new Produto(itemDTO.getIdProduto())); // Talvez trocar o itemDTO.getIdProduto() por itemDTO.idProduto
        return item;
    }
}
