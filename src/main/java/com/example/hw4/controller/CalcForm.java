package com.example.hw4.controller;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

/**
 * Created by weng on 2019/12/3.
 */
public class CalcForm {
//    public double getRes() {
//        return res;
//    }

    public String getCurrency1() {
        return currency1;
    }

    public String getCurrency2() {
        return currency2;
    }

    public float getNum1() {
        return num1;
    }

//    public void setRes(float res) {
//        this.res = res;
//    }

    public void setCurrency1(String currency1) {
        this.currency1 = currency1;
    }

    public void setCurrency2(String currency2) {
        this.currency2 = currency2;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

//    private double res;
    private String currency1;
    private String currency2;


    @NotBlank(message = "Please input number")
    @NotNull(message = "Please input number")
    @PositiveOrZero(message = "number need to be positive or zero")
    private float num1;


}
