package com.apiControleFinanceiro.ControleFInanceiro.Financeiro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Financeiro {

    @Id
    private String id;

    private String typeMoviment;

    private Number value;

    private String description;

    private String monthYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeMoviment() {
        return typeMoviment;
    }

    public void setTypeMoviment(String typeMoviment) {
        this.typeMoviment = typeMoviment;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }
}
