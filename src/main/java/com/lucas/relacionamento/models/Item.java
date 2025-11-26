package com.lucas.relacionamento.models;

import java.time.LocalDate;

import com.lucas.relacionamento.enums.Cor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    @Column(name="quantidade", nullable=false)
    private int quantidade;

    @Column(name="preco", nullable=false)
    private double preco;

    @Column(name="data_emissao")
    private LocalDate dataEmissao;
    
    @Enumerated(EnumType.STRING)
    @Column(name="cor", nullable=false)
    private Cor cor;

    public Item() {
    }

    public Item(Long id, Pedido pedidos, Produto produtos, int quantidade, double preco, LocalDate dataEmissao, Cor cor) {
        this.id = id;
        this.pedido = pedidos;
        this.produto = produtos;
        if(quantidade >= 0){
            this.quantidade = quantidade;
        }
        if(preco > 0){
            this.preco = preco;
        }
        this.dataEmissao = LocalDate.now();
        this.cor = cor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedidos() {
        return pedido;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedido = pedidos;
    }

    public Produto getProdutos() {
        return produto;
    }

    public void setProdutos(Produto produtos) {
        this.produto = produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
}
