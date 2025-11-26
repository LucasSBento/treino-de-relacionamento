package com.lucas.relacionamento.models.escola;

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
@Table(name="professor")
public class Professor {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToMany(mappedBy="professor", cascade=CascadeType.PERSIST, orphanRemoval=false)
    private List<Disciplina> disciplinas = new ArrayList<>();
    
}
