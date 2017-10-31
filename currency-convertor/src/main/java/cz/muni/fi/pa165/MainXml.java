/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165;

import cz.muni.fi.pa165.currency.CurrencyConvertor;
import java.math.BigDecimal;
import java.util.Currency;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Dominik
 */
public class MainXml {
    
    public static void main(String[] args) {
        springXmlContext();
    }
    
     private static void springXmlContext() {

        ApplicationContext applicationContext 
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        CurrencyConvertor con 
                = applicationContext.getBean(CurrencyConvertor.class);

        System.out.println("vysledok:" + con.convert(Currency.getInstance("EUR"), 
                Currency.getInstance("CZK"), new BigDecimal("1")));

    }
    
}
