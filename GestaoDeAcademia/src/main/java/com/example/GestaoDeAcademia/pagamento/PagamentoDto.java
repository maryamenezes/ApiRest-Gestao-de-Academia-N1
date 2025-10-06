package com.example.GestaoDeAcademia.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagamentoDto {

    private long id;
    private LocalDateTime data_pagamento;
    private BigDecimal valor_pago;
    private String status;
    private String forma_pagamento;
    private Long aluno_id;

    public PagamentoDto(Long id, LocalDateTime data_pagamento, BigDecimal valor_pago, String status_pagamento, String forma_pagamento, Long aluno_id) {
        this.id = id;
        this.data_pagamento = data_pagamento;
        this.valor_pago = valor_pago;
        this.status = status_pagamento;
        this.forma_pagamento = forma_pagamento;
        this.aluno_id = aluno_id;
    }

    public static PagamentoDto fromEntity(Pagamento pagamento) {
        if (pagamento == null) return null;
        return new PagamentoDto(
                pagamento.getId(),
                pagamento.getData_pagamento(),
                pagamento.getValor_pago(),
                pagamento.getStatus(),
                pagamento.getForma_pagamento(),
                pagamento.getAluno() != null ? pagamento.getAluno().getId() : null
        );
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getData_pagamento() {
        return data_pagamento;
    }

    public BigDecimal getValor_pago() {
        return valor_pago;
    }

    public String getStatus() {
        return status;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public Long getAluno_id() {
        return aluno_id;
    }
}
