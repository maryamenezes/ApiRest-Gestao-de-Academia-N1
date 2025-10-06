package com.example.GestaoDeAcademia.aluno_treino_vinculo;

import java.time.LocalDateTime;

public class Aluno_Treino_Vinculo_Dto {

        private Long id;
        private Long aluno_id;
        private Long treino_id;
        private LocalDateTime data_associacao;

        public Aluno_Treino_Vinculo_Dto(Long id, Long aluno_id, Long treino_id, LocalDateTime data_associacao) {
            this.id = id;
            this.aluno_id = aluno_id;
            this.treino_id = treino_id;
            this.data_associacao = data_associacao;
        }

    public static Aluno_Treino_Vinculo_Dto fromEntity(Aluno_Treino_Vinculo vinculo) {
        if (vinculo == null) return null;
        Long alunoId = null;
        Long treinoId = null;
        if (vinculo.getAluno() != null) {
            alunoId = vinculo.getAluno().getId();
        }
        if (vinculo.getTreino() != null) {
            treinoId = vinculo.getTreino().getId();
        }
        return new Aluno_Treino_Vinculo_Dto(
                vinculo.getId(),
                alunoId,
                treinoId,
                vinculo.getData_associacao()
        );
    }


    public Long getId() {
        return id;
    }

    public Long getAluno_id() {
        return aluno_id;
    }

    public Long getTreino_id() {
        return treino_id;
    }

    public LocalDateTime getData_associacao() {
        return data_associacao;
    }
}


