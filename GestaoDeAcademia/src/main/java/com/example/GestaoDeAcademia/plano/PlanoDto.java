package com.example.GestaoDeAcademia.plano;

import java.math.BigDecimal;

public class PlanoDto {
    private Long id;
    private String nome;
    private BigDecimal valor_mensal;

    public PlanoDto(Long id, String nome, BigDecimal valor_mensal) {
        this.id = id;
        this.nome = nome;
        this.valor_mensal = valor_mensal;
    }

    public static PlanoDto fromEntity(Plano plano) {
        if (plano == null) return null;
        return new PlanoDto(
                plano.getId(),
                plano.getNome(),
                plano.getValorMensal()
        );
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor_mensal() {
        return valor_mensal;
    }
}
