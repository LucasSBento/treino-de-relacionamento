package com.lucas.relacionamento.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome", nullable=false)
    private String nome;

    @Column(name="fornecedor", nullable=false)
    private String fornecedor;
    
    @Column(name="descricao")
    private String descricao;

    @OneToMany(mappedBy="produto", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Item> itens = new ArrayList<>();

    public Produto(Long id, String nome, String fornecedor, String descricao, List<Item> itens) {
        this.id = id;
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.descricao = descricao;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    
}
