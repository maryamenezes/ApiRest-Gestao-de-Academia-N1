package com.example.GestaoDeAcademia.treino;

public class TreinoDto {

        private Long id;
        private String nome;
        private String descricao;
        private String nivel;

    public TreinoDto(Long id, String nome, String descricao, String nivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.nivel = nivel;
    }

    public static TreinoDto fromEntity(Treino treino) {
        if (treino == null) return null;
        return new TreinoDto(
                treino.getId(),
                treino.getNome(),
                treino.getDescricao(),
                treino.getNivel()
        );
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNivel() {
        return nivel;
    }
}
