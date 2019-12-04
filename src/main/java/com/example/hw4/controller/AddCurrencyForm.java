package com.example.hw4.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * Created by weng on 2019/12/4.
 */
public class AddCurrencyForm {

    @NotNull(message = "Please input rate")
    @PositiveOrZero(message = "rate need to be positive or zero")
    private float rate;

    @Pattern(regexp = "^[\\p{L}\\p{M}*]*$", message = "Only letters are allowed")
    @Size(min = 3, max = 3, message = "Name should be 3 letters")
    private String name;

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }
}
