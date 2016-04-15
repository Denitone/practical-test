package com.deni.currency.facade;


import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.math.BigDecimal;

/**
 * @author Deni Setiawan on 15 April 2016, jakarta
 *         test-currency-api project
 */
public class CurrenceyFacadeImpl implements ICurrencyFacade {
    public CurrenceyFacadeImpl() {

    }

    @Override
    public double convertByAPI(String from, String to) {
        try {
            //String api = "https://api.fixer.io/latest?base=" + from + "&symbols=" + to;
            String api = "http://quote.yahoo.com/d/quotes.csv?f=l1&s=" + from + to + "=X";
            URL url = new URL(api);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            if (line.length() > 0) {
                return Double.parseDouble(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public String currencyAPI(String from, String to) {
        Double currency = convertByAPI(from, to);
        if (currency != 0.0) {
            return currency.toString();
        }

        return "Invalid Curse";
    }


    @Override
    public void sendGet(String from, String to) throws Exception {

        String url = "http://www.google.com/search?q=deni";
//        String url = "https://api.fixer.io/latest?base=" + from + "&symbols=" + to;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

}
