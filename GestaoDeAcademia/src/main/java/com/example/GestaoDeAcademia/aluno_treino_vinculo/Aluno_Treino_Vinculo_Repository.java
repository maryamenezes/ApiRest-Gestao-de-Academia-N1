package com.example.GestaoDeAcademia.aluno_treino_vinculo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Aluno_Treino_Vinculo_Repository extends JpaRepository<Aluno_Treino_Vinculo, Long> {
    List<Aluno_Treino_Vinculo> findByTreinoId(Long id);
}