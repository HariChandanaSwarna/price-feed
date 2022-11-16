package com.sample.stock;

import com.sample.stock.impl.StockPriceImpl;
import com.sample.stock.pojo.Price;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StockApplicationTests {

	StockNotificationService stockNotificationService;

	StockPriceImpl stockPriceImpl;

	@BeforeEach
	public void initialise()
	{
		stockPriceImpl = new StockPriceImpl();
		stockNotificationService = new StockNotificationService();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void processStockPrice()
	{
       Price price =stockNotificationService.processMessage("110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110");
       Assert.assertEquals(price.getBid(), new Double(119.61));

	}

	@Test
	void processCommission()
	{
		Price price = new Price();
		price.setAsk(119.1);
		price.setBid(118.1);
		stockPriceImpl.processCommission(price);
		Assert.assertEquals(price.getAsk(),new Double(119.2191));
	}



}
