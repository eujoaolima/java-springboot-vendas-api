package com.soulcode.vendas.models.dtos;

import com.soulcode.vendas.models.Produto;

public class ProdutoDTO {
    private Long id;

    private String codigo;

    private String descricao;

    private Float preco;

    private String unidadeMedida;

    private String grupo;

    private String urlFoto;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id) {
        this.id = id;
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.codigo = produto.getCodigo();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.unidadeMedida = produto.getUnidadeMedida();
        this.grupo = produto.getGrupo();
        this.urlFoto = produto.getUrlFoto();
    }

    public static Produto convert(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setCodigo(produtoDTO.getCodigo());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setGrupo(produtoDTO.getGrupo());
        produto.setPreco(produtoDTO.getPreco());
        produto.setUnidadeMedida(produtoDTO.getUnidadeMedida());
        produto.setUrlFoto(produtoDTO.getUrlFoto());
        return produto;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPreco() {
        return this.preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getUnidadeMedida() {
        return this.unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getGrupo() {
        return this.grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getUrlFoto() {
        return this.urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
