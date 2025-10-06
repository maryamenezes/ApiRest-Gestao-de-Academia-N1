package com.example.GestaoDeAcademia.pagamento;

import com.example.GestaoDeAcademia.aluno.Aluno;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_PAGAMENTO")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime data_pagamento;

    @Column(nullable = false)
    private BigDecimal valor_pago;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String forma_pagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDateTime data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public BigDecimal getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(BigDecimal valor_pago) {
        this.valor_pago = valor_pago;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
