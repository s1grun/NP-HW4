package com.example.hw4.domain;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.Objects;

@Entity
@Table(name = "currency", schema = "public", catalog = "postgres")
public class CurrencyEntity implements CurrencyDTO{
    private String name;
    private double rate;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public CurrencyEntity(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public CurrencyEntity() {
    }

    @Id
    @Column(name = "name", nullable = false, length = -1)
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyEntity that = (CurrencyEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Basic
    @Column(name = "rate", nullable = false, precision = 5)
    @Override
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
