package com.deni.currency.controller;

import com.deni.currency.facade.CurrenceyFacadeImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.math.BigDecimal;

@ViewScoped
@ManagedBean
public class CurencyFormCtrl implements Serializable {

    private static final long serialVersionUID = -6239437588285327644L;

    private String name;
    private String fromInput;
    private String toInput;
    private CurrenceyFacadeImpl currenceyFacade;
    private String output;


    @PostConstruct
    public void init() {
        fromInput = "USD";
        toInput = "IDR";
        currenceyFacade = new CurrenceyFacadeImpl();
    }


    public void generateCurrency() throws Exception {
        output = currenceyFacade.currencyAPI(fromInput, toInput);
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getFromInput() {
        return fromInput;
    }

    public void setFromInput(String fromInput) {
        this.fromInput = fromInput;
    }

    public String getToInput() {
        return toInput;
    }

    public void setToInput(String toInput) {
        this.toInput = toInput;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}