package com.example.hw4.application;

import com.example.hw4.domain.CurrencyDTO;
import com.example.hw4.domain.CurrencyEntity;
import com.example.hw4.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currRepo;

    public List<? extends CurrencyDTO> getAllCurrencies() {
        return currRepo.findAll();
    }

    public CurrencyDTO getCurrencyByName(String name){

        return currRepo.getCurrencyByName(name);
    }

}
