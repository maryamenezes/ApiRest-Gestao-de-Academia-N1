package com.example.GestaoDeAcademia.aluno;

import java.time.LocalDate;

public class AlunoDto {

    public AlunoDto(int id, String nome, String cpf, LocalDate data_nascimento, boolean ativo, Long aLong) {
    }

        private Long id;
        private String nome;
        private String cpf;
        private LocalDate data_nascimento;
        private boolean ativo;
        private Long planoId;

        public AlunoDto(Long id, String nome, String cpf, LocalDate dataNascimento, boolean ativo, Long planoId) {
            this.id = id;
            this.nome = nome;
            this.cpf = cpf;
            this.data_nascimento = dataNascimento;
            this.ativo = ativo;
            this.planoId = planoId;
        }

        public static AlunoDto fromEntity(Aluno aluno) {
            if (aluno == null) return null;
            return new AlunoDto(
                    aluno.getId(),
                    aluno.getNome(),
                    aluno.getCpf(),
                    aluno.getData_nascimento(),
                    aluno.isAtivo(),
                    aluno.getPlano() != null ? aluno.getPlano().getId() : null
            );
        }

        public Long getId() {
            return id; }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        public LocalDate getDataNascimento() {
            return data_nascimento;
        }

        public boolean isAtivo() {
            return ativo;
        }

        public Long getPlanoId() {
            return planoId;
        }
    }
    
