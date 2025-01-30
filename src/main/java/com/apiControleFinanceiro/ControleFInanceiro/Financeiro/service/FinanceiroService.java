package com.apiControleFinanceiro.ControleFInanceiro.Financeiro.service;

import com.apiControleFinanceiro.ControleFInanceiro.Financeiro.dto.ResponseFinancialDTO;
import com.apiControleFinanceiro.ControleFInanceiro.Financeiro.dto.ResumoFinanceiroAggregation;
import com.apiControleFinanceiro.ControleFInanceiro.Financeiro.model.Financeiro;
import com.apiControleFinanceiro.ControleFInanceiro.Financeiro.repository.FinanceiroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FinanceiroService {

    @Autowired
    private FinanceiroRepository financeiroRepository;

    public List<Financeiro> findAll() {
        return financeiroRepository.findAll();
    }

    public Financeiro findById(String id) {
        return this.financeiroRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    public List<Financeiro> findByMonthYear(String monthYear) {
        return this.financeiroRepository.findByMonthYear(monthYear);
    }

    public Financeiro save(Financeiro financeiro) {
        return this.financeiroRepository.save(financeiro);
    }

    public void delete(String id) {
        this.financeiroRepository.deleteById(id);
    }

    public Financeiro update(Financeiro financeiro){
        if (financeiro.getId() == null || financeiro.getId().isEmpty()) {
            throw new IllegalArgumentException("O ID do registro a ser atualizado não pode ser nulo ou vazio.");
        }
        var financeiroEntity = this.findById(financeiro.getId());
        BeanUtils.copyProperties(financeiro, financeiroEntity, "id");
        return this.financeiroRepository.save(financeiroEntity);
    }

    public ResponseFinancialDTO getResumoFinanceiro(String monthYear) {
        ResumoFinanceiroAggregation resumo = financeiroRepository.getResumoFinanceiro(monthYear);

        if (resumo == null) {
            return new ResponseFinancialDTO(0, 0, 0);
        }

        // Mapeia o resultado da agregação para o DTO
        return new ResponseFinancialDTO(
                resumo.getEntrada(),
                resumo.getSaida(),
                resumo.getSaldo()
        );
    }
}
