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
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome", nullable=false, length=100)
    private String nome;

    @Column(name="cpf", nullable=false, unique=true, length=20)
    private String cpf;

    @Column(name="email", nullable=false, unique=true, length=100)
    private String email;

    @Column(name="senha", nullable=false, length=100)
    private String senha;

    @OneToMany(mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Pedido> pedidos = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Long id, String nome, String cpf, String email, String senha, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.pedidos = pedidos;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
