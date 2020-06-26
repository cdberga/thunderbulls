package com.thunderbulls.stock;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.repository.StockRepository;

public class AddStockTest {

	private AddStock add;
	
	@Before
	public void initialize() {
		StockRepository repo = new MockStockRepository();
		repo.save(new Stock("VIVT4"));
		add = new AddStock();
		add.setRepository(repo);
	}
	
	@Test
	public void canExistentStockBeAdded() {
		ResponseModel<Stock> response = add.add(new Stock("VIVT4"));
		assertNotNull(response.getError());
	}
	
	@Test
	public void canAddNewStock() {
		ResponseModel<Stock> response = add.add(new Stock("RADL3"));
		assertNull(response.getError());
	}
}
