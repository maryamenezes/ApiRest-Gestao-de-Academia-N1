package com.example.GestaoDeAcademia.plano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;


    public PlanoDto findById(Long id) {
        return PlanoDto.fromEntity(planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado")));
    }

    public List<PlanoDto> findAll() {
        return planoRepository.findAll()
                .stream()
                .map(PlanoDto::fromEntity)
                .toList();
    }

    public PlanoDto save(Plano plano) {
        return PlanoDto.fromEntity(planoRepository.save(plano));
    }

    public PlanoDto update(Plano plano) {
        if (!planoRepository.existsById(plano.getId())) {
            throw new RuntimeException("Plano não encontrado");
        }
        return PlanoDto.fromEntity(planoRepository.save(plano));
    }

    public void delete(Long id) {
        if (!planoRepository.existsById(id)) {
            throw new RuntimeException("Plano não encontrado");
        }
        planoRepository.deleteById(id);
    }
}
