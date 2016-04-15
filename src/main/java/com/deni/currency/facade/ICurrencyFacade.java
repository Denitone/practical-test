package com.deni.currency.facade;

import java.math.BigDecimal;

/**
 * @author Deni Setiawan on 15 April 2016, jakarta
 *         test-currency-api project
 */
public interface ICurrencyFacade {

    public double convertByAPI(String from, String to);

    public String currencyAPI(String from, String to);

    public void sendGet(String from, String to) throws Exception;

}
