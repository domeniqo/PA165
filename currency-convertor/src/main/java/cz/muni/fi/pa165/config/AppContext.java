/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.config;

import cz.muni.fi.pa165.currency.CurrencyConvertor;
import cz.muni.fi.pa165.currency.CurrencyConvertorImpl;
import cz.muni.fi.pa165.currency.ExchangeRateTable;
import cz.muni.fi.pa165.currency.ExchangeRateTableImpl;
import javax.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Dominik
 */
@Configuration
public class AppContext {
    
    @Inject
    private ExchangeRateTable table;
    
    @Bean
    public ExchangeRateTable table(){
        return new ExchangeRateTableImpl();
    }
    
    @Bean
    public CurrencyConvertor con(){
        return new CurrencyConvertorImpl(table);
    }
}
