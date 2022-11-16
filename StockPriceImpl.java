package com.sample.stock.impl;

import com.sample.stock.pojo.Price;
import com.sample.stock.StockNotificationService;
import com.sample.stock.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockPriceImpl implements StockPrice {
    @Autowired
    StockNotificationService stockNotificationService;

    @Override
    public Price processStockPrice() {
        Price stockPrice = stockNotificationService.processMessage("110, EUR/GBP, 1.1000,1.2000, 12th Oct");
        processCommission(stockPrice);
        return stockPrice;
    }

    /**
     * Calculate the commission values for ask and bid values
     * @param stockPrice
     */

    public void processCommission(Price stockPrice) {
        Double bidPrice = stockPrice.getBid();
        Double bidCommission = bidPrice- (0.1/100) * bidPrice;
        stockPrice.setBid(bidCommission);
        Double askPrice = stockPrice.getAsk();
        Double askCommission = askPrice+ (0.1/100) * askPrice;
        stockPrice.setAsk(askCommission);
    }
}
