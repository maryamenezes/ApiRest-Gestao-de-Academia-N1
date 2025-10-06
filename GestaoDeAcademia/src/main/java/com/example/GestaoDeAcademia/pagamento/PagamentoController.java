package com.example.GestaoDeAcademia.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pagamentoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PagamentoDto>> findAll() {
        return ResponseEntity.ok(pagamentoService.findAll());
    }

    @PostMapping
    public ResponseEntity<PagamentoDto> save(@RequestBody Pagamento pagamento,
                                             @RequestParam Long alunoId) {
        PagamentoDto dto = pagamentoService.save(pagamento, alunoId);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
