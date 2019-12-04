package com.example.hw4.repository;

import com.example.hw4.domain.CurrencyDTO;
import com.example.hw4.domain.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, List> {
    //CurrencyEntity getListOfCurrency(List currencyList);
    CurrencyDTO getCurrencyByName(String name);
}
