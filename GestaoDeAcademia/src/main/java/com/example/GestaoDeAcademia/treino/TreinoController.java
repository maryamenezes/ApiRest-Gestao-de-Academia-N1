package com.example.GestaoDeAcademia.treino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @GetMapping("/{id}")
    public ResponseEntity<TreinoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(treinoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<TreinoDto>> findAll() {
        return ResponseEntity.ok(treinoService.findAll());
    }

    @PostMapping
    public ResponseEntity<TreinoDto> save(@RequestBody Treino treino) {
        TreinoDto dto = treinoService.save(treino);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping
    public ResponseEntity<TreinoDto> update(@RequestBody Treino treino) {
        return ResponseEntity.ok(treinoService.update(treino));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        treinoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
