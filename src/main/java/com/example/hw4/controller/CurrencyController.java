package com.example.hw4.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by weng on 2019/12/3.
 */
@Controller
@Scope("session")
public class CurrencyController {

    @GetMapping("/")
    public String Hello(){
        return "hello";
    }


}
