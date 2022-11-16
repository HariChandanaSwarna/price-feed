package com.sample.stock;

import com.sample.stock.pojo.Price;
import org.springframework.stereotype.Service;

import javax.jms.Message;
import javax.jms.MessageListener;

@Service
public class StockNotificationService implements MessageListener {
    public Price processMessage(String message)
    {
        //message is in CSV format so splitting them to get the values
        String[] values = message.split(",");
        Price price = new Price();
        price.setUniqueId(values[0]);
        price.setInstrumentName(values[1]);
        price.setBid(Double.parseDouble(values[2]));
        price.setAsk(Double.parseDouble(values[3]));
        price.setTimestamp(values[4]);
        return price;

    }

    @Override
    public void onMessage(Message message) {
        processMessage(message.toString());
    }
}
