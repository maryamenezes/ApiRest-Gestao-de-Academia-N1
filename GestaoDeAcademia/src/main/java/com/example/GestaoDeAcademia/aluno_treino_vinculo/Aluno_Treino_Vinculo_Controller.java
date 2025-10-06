package com.example.GestaoDeAcademia.aluno_treino_vinculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vinculos")
public class Aluno_Treino_Vinculo_Controller {

    @Autowired
    private Aluno_Treino_Vinculo_Service vinculoService;

    @GetMapping
    public ResponseEntity<List<Aluno_Treino_Vinculo_Dto>> findAll() {
        return ResponseEntity.ok(vinculoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Aluno_Treino_Vinculo_Dto> vincular(@RequestParam Long alunoId,
                                                             @RequestParam Long treinoId) {
        Aluno_Treino_Vinculo_Dto dto = vinculoService.vincular(alunoId, treinoId);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}

