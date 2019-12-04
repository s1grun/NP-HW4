package com.example.hw4.controller;

import com.example.hw4.domain.IllegalException;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by weng on 2019/12/4.
 */
public class ErrorHandler implements ErrorController {
    static final String NUMBER_NULL ="number could not be null";
    static final String NUMBER_NEG ="number should above or equal to 0";
    static final String ERR_KEY = "err_type";
    static final String ERR_VALUE = "err_msg";



    @ExceptionHandler(IllegalException.class)
    @ResponseStatus(HttpStatus.OK)
    public String handleRequestError(IllegalException e, Model model){
        System.out.println("404-");
        return "error";
    }

    @GetMapping("/error")
    public String handleHttpError(HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println("404-");
        int statusCode = Integer.parseInt(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString());

        if (statusCode == HttpStatus.NOT_FOUND.value()) {
            model.addAttribute(ERR_KEY, "404");
            model.addAttribute(ERR_VALUE, "PAGE NOT FOUND");

            response.setStatus(statusCode);
        } else {
            model.addAttribute(ERR_KEY, "ERROR");
            model.addAttribute(ERR_KEY, "GENERAL ERROR");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return "error";
    }





    @Override
    public String getErrorPath() {
        return "/error";
    }
}
