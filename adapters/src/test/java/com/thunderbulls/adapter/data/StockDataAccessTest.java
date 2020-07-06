package com.thunderbulls.adapter.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.repository.StockRepository;

public class StockDataAccessTest {
	
	private StockRepository dataAccess;

	@Before
	public void initialize() {
		dataAccess = new MockStockDataAccess();
		dataAccess.save(new Stock("VALE5", "VALE SA"));
	}

	@Test
	public void findStockDataInexistent() {
		Stock stock = dataAccess.findByCode("PETR4");
		assertNull(stock);
	}
	
	@Test
	public void findStockData() {
		Stock stock = dataAccess.findByCode("VALE5");
		assertNotNull(stock);
	}

}
