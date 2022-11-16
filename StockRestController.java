package com.sample.stock.controller;

import com.sample.stock.impl.StockPriceImpl;
import com.sample.stock.pojo.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Endpoint where we get the stock prices
 */

@RestController
public class StockRestController {

    @Autowired
    StockPriceImpl stockPriceImpl;

    @GetMapping("/stock/prices")
    public Price getStocks(HttpServletRequest request, Price response)
    {
        return stockPriceImpl.processStockPrice();
    }



}
