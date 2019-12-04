package com.example.hw4.controller;

import com.example.hw4.application.CurrencyService;
import com.example.hw4.domain.CurrencyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.text.DecimalFormat;

import java.util.List;

/**
 * Created by weng on 2019/12/3.
 */
@Controller
@Scope("session")
public class CurrencyController {

    @Autowired
    private CurrencyService service;
    private static DecimalFormat df = new DecimalFormat("0.00");
//    private AccountDTO currentAcct;

    @GetMapping("/")
    public String Hello(Model model, CalcForm calcForm){
        List<? extends CurrencyDTO> currencyList = service.getAllCurrencies();
        model.addAttribute("currencyList", currencyList);
//        model.addAttribute("CalcForm", new CalcForm());
        return "index";
    }


    @PostMapping("/calc")
    public String calc_rate(CalcForm calcForm,Model model){
        double res;
        String name1 = calcForm.getCurrency1();
        String name2 = calcForm.getCurrency2();
        float num1 = calcForm.getNum1();
        double rate1 = service.getCurrencyByName(name1).getRate();
        double rate2 = service.getCurrencyByName(name2).getRate();
        res = num1*rate2/rate1;
        model.addAttribute("res", df.format(res));

        List<? extends CurrencyDTO> currencyList = service.getAllCurrencies();
        model.addAttribute("currencyList", currencyList);

        return "index";
    }


}
