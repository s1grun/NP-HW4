package com.example.hw4.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "currency", schema = "public", catalog = "postgres")
public class CurrencyEntity {
    private String name;
    private double rate;

    @Id
    @Column(name = "name", nullable = false, length = -1)
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
    @Column(name = "rate", nullable = false, precision = 0)
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
