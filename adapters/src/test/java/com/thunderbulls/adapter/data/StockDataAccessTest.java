package com.thunderbulls.adapter.data;

import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.thunderbulls.stock.Stock;

public class StockDataAccessTest {

	@Test
	public void findStockData() {
		StockDataAccess dataAccess = new StockDataAccess();
		Stock stock = dataAccess.findByCode("PETR4");
		StockDataEntity data = dataAccess.toDataEntity(stock);
		assertNull(data);
	}

}
