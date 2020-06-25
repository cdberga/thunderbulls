package com.thunderbulls.stock;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

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
	
	@Test(expected = IllegalArgumentException.class)
	public void canExistentStockBeAdded() {
		add.add(new Stock("VIVT4"));
	}
	
	@Test
	public void canAddNewStock() {
		assertNotNull(add.add(new Stock("RADL3")));
	}
}
