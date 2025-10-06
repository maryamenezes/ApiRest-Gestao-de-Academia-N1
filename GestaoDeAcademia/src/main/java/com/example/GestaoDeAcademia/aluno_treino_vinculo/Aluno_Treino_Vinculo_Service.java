package com.example.GestaoDeAcademia.aluno_treino_vinculo;

import com.example.GestaoDeAcademia.aluno.Aluno;
import com.example.GestaoDeAcademia.aluno.AlunoRepository;
import com.example.GestaoDeAcademia.treino.Treino;
import com.example.GestaoDeAcademia.treino.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class Aluno_Treino_Vinculo_Service {

    @Autowired
    private Aluno_Treino_Vinculo_Repository vinculoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TreinoRepository treinoRepository;

    public List<Aluno_Treino_Vinculo_Dto> findAll() {
        return vinculoRepository.findAll()
                .stream()
                .map(Aluno_Treino_Vinculo_Dto::fromEntity)
                .toList();
    }

    public Aluno_Treino_Vinculo_Dto vincular(Long alunoId, Long treinoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Treino treino = treinoRepository.findById(treinoId)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        Aluno_Treino_Vinculo vinculo = new Aluno_Treino_Vinculo();
        vinculo.setAluno(aluno);
        vinculo.setTreino(treino);
        vinculo.setData_associacao(LocalDateTime.now());

        return Aluno_Treino_Vinculo_Dto.fromEntity(vinculoRepository.save(vinculo));
    }
}
