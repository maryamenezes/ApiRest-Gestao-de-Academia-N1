package com.example.GestaoDeAcademia.aluno;

import com.example.GestaoDeAcademia.plano.Plano;
import com.example.GestaoDeAcademia.plano.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PlanoRepository planoRepository;

    public AlunoDto findById(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return AlunoDto.fromEntity(aluno);
    }

    public List<AlunoDto> findAll() {
        return alunoRepository.findAll()
                .stream()
                .map(AlunoDto::fromEntity)
                .toList();
    }

    public AlunoDto save(Aluno aluno, Long planoId) {
        if (planoId != null) {
            Plano plano = planoRepository.findById(planoId)
                    .orElseThrow(() -> new RuntimeException("Plano não encontrado"));
            aluno.setPlano(plano);
        }
        Aluno saved = alunoRepository.save(aluno);
        return AlunoDto.fromEntity(saved);
    }

    public AlunoDto update(Aluno aluno, Long planoId) {
        if (!alunoRepository.existsById(aluno.getId())) {
            throw new RuntimeException("Aluno não encontrado");
        }
        if (planoId != null) {
            Plano plano = planoRepository.findById(planoId)
                    .orElseThrow(() -> new RuntimeException("Plano não encontrado"));
            aluno.setPlano(plano);
        }
        Aluno updated = alunoRepository.save(aluno);
        return AlunoDto.fromEntity(updated);
    }

    public AlunoDto alterarStatus(Long id, boolean ativo) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        aluno.setAtivo(ativo);
        return AlunoDto.fromEntity(alunoRepository.save(aluno));
    }
}
