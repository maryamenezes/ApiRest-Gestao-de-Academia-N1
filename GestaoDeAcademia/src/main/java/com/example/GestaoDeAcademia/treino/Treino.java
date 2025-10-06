package com.example.GestaoDeAcademia.treino;

import com.example.GestaoDeAcademia.aluno_treino_vinculo.Aluno_Treino_Vinculo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_TREINO")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = false)
    private String nivel;

    @OneToMany(mappedBy = "treino", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Aluno_Treino_Vinculo> alunos;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public List<Aluno_Treino_Vinculo> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno_Treino_Vinculo> alunos) {
        this.alunos = alunos;
    }
}