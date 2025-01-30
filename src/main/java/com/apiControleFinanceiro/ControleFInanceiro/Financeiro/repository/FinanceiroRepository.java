package com.apiControleFinanceiro.ControleFInanceiro.Financeiro.repository;

import com.apiControleFinanceiro.ControleFInanceiro.Financeiro.dto.ResumoFinanceiroAggregation;
import com.apiControleFinanceiro.ControleFInanceiro.Financeiro.model.Financeiro;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface FinanceiroRepository extends MongoRepository<Financeiro, String>{

    @Query("{ 'monthYear': ?0 }")
    List<Financeiro> findByMonthYear(String monthYear);

    @Aggregation(pipeline = {
            "{ $match: { monthYear: ?0 } }", // Filtra pelo monthYear
            "{ $group: { _id: '$typeMoviment', total: { $sum: '$value' } } }", // Agrupa por tipo e soma os valores
            "{ $group: { _id: null, entrada: { $sum: { $cond: { if: { $eq: ['$_id', 'E'] }, then: '$total', else: 0 } } }, saida: { $sum: { $cond: { if: { $eq: ['$_id', 'S'] }, then: '$total', else: 0 } } } } }", // Calcula a soma de E e S
            "{ $project: { _id: 0, entrada: { $ifNull: ['$entrada', 0] }, saida: { $ifNull: ['$saida', 0] }, saldo: { $ifNull: [{ $subtract: ['$entrada', '$saida'] }, 0] } } }" // Calcula a diferença (saldo) e trata valores nulos
    })
    ResumoFinanceiroAggregation getResumoFinanceiro(String monthYear);
}
