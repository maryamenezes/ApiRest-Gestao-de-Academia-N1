package com.example.GestaoDeAcademia.aluno_treino_vinculo;

import com.example.GestaoDeAcademia.aluno.Aluno;
import com.example.GestaoDeAcademia.treino.Treino;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ALUNO_TREINO_VINCULO")
public class Aluno_Treino_Vinculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime data_associacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treino_id", nullable = false)
    private Treino treino;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_associacao() {
        return data_associacao;
    }

    public void setData_associacao(LocalDateTime data_ssociacao) {
        this.data_associacao = data_ssociacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }
}
