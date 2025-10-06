package com.example.GestaoDeAcademia.plano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(planoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PlanoDto>> findAll() {
        return ResponseEntity.ok(planoService.findAll());
    }

    @PostMapping
    public ResponseEntity<PlanoDto> save(@RequestBody Plano plano) {
        PlanoDto dto = planoService.save(plano);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping
    public ResponseEntity<PlanoDto> update(@RequestBody Plano plano) {
        return ResponseEntity.ok(planoService.update(plano));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        planoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}