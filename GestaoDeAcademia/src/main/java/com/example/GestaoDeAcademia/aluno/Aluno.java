package com.example.GestaoDeAcademia.aluno;

import com.example.GestaoDeAcademia.aluno_treino_vinculo.Aluno_Treino_Vinculo;
import com.example.GestaoDeAcademia.pagamento.Pagamento;
import com.example.GestaoDeAcademia.plano.Plano;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

    @Entity
    @Table(name = "TB_ALUNO")
    public class Aluno {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(nullable = false)
        private String nome;

        @Column(nullable = false, unique = true)
        private String cpf;

        @Column(nullable = false)
        private LocalDate data_nascimento;

        private boolean ativo;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "plano_id")
        private Plano plano;

        @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Pagamento> pagamentos;

        @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Aluno_Treino_Vinculo> treinos;

        public long getId() {
            return id;
        }

        public void setId(long id) {
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

        public LocalDate getData_nascimento() {
            return data_nascimento;
        }

        public void setData_nascimento(LocalDate data_nascimento) {
            this.data_nascimento = data_nascimento;
        }

        public boolean isAtivo() {
            return ativo;
        }

        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
        }

        public Plano getPlano() {
            return plano;
        }

        public void setPlano(Plano plano) {
            this.plano = plano;
        }

        public List<Pagamento> getPagamentos() {
            return pagamentos;
        }

        public void setPagamentos(List<Pagamento> pagamentos) {
            this.pagamentos = pagamentos;
        }

        public List<Aluno_Treino_Vinculo> getTreinos() {
            return treinos;
        }

        public void setTreinos(List<Aluno_Treino_Vinculo> treinos) {
            this.treinos = treinos;
        }
    }

