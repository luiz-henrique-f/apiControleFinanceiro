package com.apiControleFinanceiro.ControleFInanceiro.Financeiro.repository;

import com.apiControleFinanceiro.ControleFInanceiro.Financeiro.model.Financeiro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FinanceiroRepository extends MongoRepository<Financeiro, String>{

    @Query("{ 'monthYear': ?0 }")
    List<Financeiro> findByMonthYear(String monthYear);
}
