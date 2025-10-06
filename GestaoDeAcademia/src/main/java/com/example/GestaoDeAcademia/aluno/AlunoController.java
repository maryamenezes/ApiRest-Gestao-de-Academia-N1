package com.example.GestaoDeAcademia.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AlunoDto>> findAll() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @PostMapping
    public ResponseEntity<AlunoDto> save(@RequestBody Aluno aluno,
                                         @RequestParam(required = false) Long planoId) {
        AlunoDto dto = alunoService.save(aluno, planoId);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping
    public ResponseEntity<AlunoDto> update(@RequestBody Aluno aluno,
                                           @RequestParam(required = false) Long planoId) {
        return ResponseEntity.ok(alunoService.update(aluno, planoId));
    }


    @PatchMapping("/{id}/status")
    public ResponseEntity<AlunoDto> alterarStatus(@PathVariable Long id,
                                                  @RequestParam boolean ativo) {
        return ResponseEntity.ok(alunoService.alterarStatus(id, ativo));
    }
}
