package com.lucas.relacionamento.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="previsao", nullable=false)
    private LocalDate previsao;

    @Column(name="emissao")
    private LocalDate emissao;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy="pedido", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Item> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Long id, LocalDate previsao, LocalDate emissao, Usuario usuario, List<Item> itens) {
        this.id = id;
        this.previsao = previsao;
        this.emissao = emissao;
        this.usuario = usuario;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPrevisao() {
        return previsao;
    }

    public void setPrevisao(LocalDate previsao) {
        this.previsao = previsao;
    }

    public LocalDate getEmissao() {
        return emissao;
    }

    public void setEmissao(LocalDate emissao) {
        this.emissao = emissao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    
}
