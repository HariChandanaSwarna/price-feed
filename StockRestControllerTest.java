package com.sample.stock.controller;

import com.sample.stock.impl.StockPriceImpl;
import com.sample.stock.pojo.Price;

import mockit.MockUp;
import org.junit.jupiter.api.Test;



class StockRestControllerTest {

   //@Test
    public void testgetStocks() throws Exception {
        new MockUp<StockPriceImpl>()
        {
            @mockit.Mock
            public Price processStockPrice()
            {
                return new Price();
            }
        };



    }

}