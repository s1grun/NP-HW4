package com.example.hw4.controller;

import com.example.hw4.application.CurrencyService;
import com.example.hw4.domain.CurrencyDTO;
import com.example.hw4.domain.CurrencyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by weng on 2019/12/3.
 */
@Controller
@Scope("session")
public class CurrencyController {

    @Autowired
    private CurrencyService service;
//    private AccountDTO currentAcct;

    @GetMapping("/")
    public String Hello(Model model ){
        List<? extends CurrencyDTO> currencyList = service.getAllCurrencies();
        model.addAttribute("currencyList",currencyList);
        return "index";
    }


}
