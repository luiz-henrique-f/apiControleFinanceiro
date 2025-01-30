package com.apiControleFinanceiro.ControleFInanceiro.Financeiro.controller;

import com.apiControleFinanceiro.ControleFInanceiro.Financeiro.dto.ResponseFinancialDTO;
import com.apiControleFinanceiro.ControleFInanceiro.Financeiro.model.Financeiro;
import com.apiControleFinanceiro.ControleFInanceiro.Financeiro.service.FinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financeiro")
@CrossOrigin(origins = "*")
public class FinanceiroController {

    @Autowired
    private FinanceiroService financeiroService;

    @GetMapping
    public List<Financeiro> getAll() {
        return this.financeiroService.findAll();
    }

    @GetMapping("/{id}")
    public Financeiro findById(@PathVariable String id) {
        return this.financeiroService.findById(id);
    }

    @GetMapping("/monthYear")
    public List<Financeiro> findByMonthYear(@RequestParam("month") String month, @RequestParam("year") String year) {
        return this.financeiroService.findByMonthYear(month + "/" + year);
    }

    @GetMapping("/resumoFinanceiro")
    public ResponseFinancialDTO getResumoFinanceiro(@RequestParam("month") String month, @RequestParam("year") String year) {
        return financeiroService.getResumoFinanceiro(month + "/" + year);
    }

    @PostMapping
    public ResponseEntity<Financeiro> save(@RequestBody Financeiro financeiro) {
        financeiro = this.financeiroService.save(financeiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(financeiro);
    }

    @PutMapping
    public ResponseEntity<Financeiro> update(@RequestBody Financeiro financeiro) {
        financeiro = this.financeiroService.update(financeiro);
        return ResponseEntity.ok(financeiro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.financeiroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
