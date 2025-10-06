package com.example.GestaoDeAcademia.treino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    private static final List<String> NIVEIS_VALIDOS = List.of("INICIANTE", "INTERMEDIARIO", "AVANCADO");

    public TreinoDto findById(Long id) {
        return TreinoDto.fromEntity(treinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado")));
    }

    public List<TreinoDto> findAll() {
        return treinoRepository.findAll()
                .stream()
                .map(TreinoDto::fromEntity)
                .toList();
    }

    public TreinoDto save(Treino treino) {
        validarNivel(treino.getNivel());
        return TreinoDto.fromEntity(treinoRepository.save(treino));
    }

    public TreinoDto update(Treino treino) {
        if (!treinoRepository.existsById(treino.getId())) {
            throw new RuntimeException("Treino não encontrado");
        }
        validarNivel(treino.getNivel());
        return TreinoDto.fromEntity(treinoRepository.save(treino));
    }

    public void delete(Long id) {
        if (!treinoRepository.existsById(id)) {
            throw new RuntimeException("Treino não encontrado");
        }
        treinoRepository.deleteById(id);
    }

    private void validarNivel(String nivel) {
        if (nivel == null || !NIVEIS_VALIDOS.contains(nivel.toUpperCase())) {
            throw new RuntimeException("Nível inválido. Use apenas: INICIANTE, INTERMEDIARIO ou AVANCADO.");
        }
    }
}


