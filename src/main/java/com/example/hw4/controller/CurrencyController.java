package com.example.hw4.controller;

import com.example.hw4.application.CurrencyService;
import com.example.hw4.domain.CurrencyDTO;
import com.example.hw4.domain.CurrencyEntity;
import com.example.hw4.domain.IllegalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.text.DecimalFormat;


import javax.naming.Binding;
import javax.validation.Valid;
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
    public String Hello(Model model, CalcForm calcForm, AddCurrencyForm addCurrencyForm){
        List<? extends CurrencyDTO> currencyList = service.getAllCurrencies();
        model.addAttribute("currencyList", currencyList);
//        model.addAttribute("CalcForm", new CalcForm());
        return "index";
    }


    @PostMapping("/calc")
    public String calc_rate(@Valid CalcForm calcForm, BindingResult bindingResult, Model model) throws IllegalException{
        List<? extends CurrencyDTO> currencyList = service.getAllCurrencies();
        model.addAttribute("currencyList", currencyList);
        model.addAttribute("addCurrencyForm", new AddCurrencyForm());
        if (bindingResult.hasErrors()) {
//            model.addAttribute("addCurrencyForm", new AddCurrencyForm());
            return "index";
        }
        double res;
        String name1 = calcForm.getCurrency1();
        String name2 = calcForm.getCurrency2();
        float num1 = calcForm.getNum1();
        double rate1 = service.getCurrencyByName(name1).getRate();
        double rate2 = service.getCurrencyByName(name2).getRate();
        res = num1*rate2/rate1;
        model.addAttribute("res", df.format(res));
        return "index";
    }

    @PostMapping("/addCurrency")
    public String addCurrency(@Valid AddCurrencyForm addCurrencyForm, BindingResult bindingResult, Model model) throws IllegalException{

        if (bindingResult.hasErrors()) {
            List<? extends CurrencyDTO> currencyList = service.getAllCurrencies();
            model.addAttribute("currencyList", currencyList);
            model.addAttribute("calcForm", new CalcForm());
            return "index";
        }

        String name = addCurrencyForm.getName();
        float rate = addCurrencyForm.getRate();

        if(service.getCurrencyByName(name) == null){
            service.createCurrency(name,rate);
            List<? extends CurrencyDTO> currencyList = service.getAllCurrencies();
            model.addAttribute("currencyList", currencyList);
            model.addAttribute("calcForm", new CalcForm());
        }else {
            throw new IllegalException("currency "+ name+" already exist!");
//            model.addAttribute(ErrorHandler.ERR_KEY,"err");
//            model.addAttribute(ErrorHandler.ERR_VALUE,"currency "+ name+" already exist!");
//            return ErrorHandler.ERROR_PATH;
        }

        return "index";
    }

}
