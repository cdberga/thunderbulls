package com.thunderbulls.adapter.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.stock.Stock;

public class StockDataAccessTest {
	
	private StockDataAccess dataAccess;
	private StockDatabase database;

	@Before
	public void initialize() {
		database = new MockStockDatabase();
		dataAccess = new StockDataAccess(database);
		dataAccess.save(new Stock("VALE5", "VALE SA"));
		dataAccess.save(new Stock("VALE3", "VALE SA"));
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
	
	@Test
	public void findStockByCompany() {
		List<Stock> stock = dataAccess.findByCorpName("VALE SA");
		assertNotNull(stock);
		assertTrue(stock.size()==2);
	}

}
