package com.example.GestaoDeAcademia.pagamento;

import com.example.GestaoDeAcademia.aluno.Aluno;
import com.example.GestaoDeAcademia.aluno.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    private static final List<String> STATUS_VALIDOS = List.of("PAGO", "PENDENTE", "ATRASADO");
    private static final List<String> FORMAS_VALIDAS = List.of("PIX", "DINHEIRO", "CARTAO");

    public PagamentoDto findById(Long id) {
        return PagamentoDto.fromEntity(pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado")));
    }

    public List<PagamentoDto> findAll() {
        return pagamentoRepository.findAll()
                .stream()
                .map(PagamentoDto::fromEntity)
                .toList();
    }

    public PagamentoDto save(Pagamento pagamento, Long alunoId) {
        validarStatus(pagamento.getStatus());
        validarForma(pagamento.getForma_pagamento());

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        pagamento.setAluno(aluno);

        return PagamentoDto.fromEntity(pagamentoRepository.save(pagamento));
    }


    private void validarStatus(String status) {
        if (status == null || !STATUS_VALIDOS.contains(status.toUpperCase())) {
            throw new RuntimeException("Status inválido. Use apenas: PAGO, PENDENTE ou ATRASADO.");
        }
    }

    private void validarForma(String forma) {
        if (forma == null || !FORMAS_VALIDAS.contains(forma.toUpperCase())) {
            throw new RuntimeException("Forma de pagamento inválida. Use apenas: PIX, DINHEIRO ou CARTAO.");
        }
    }
}
