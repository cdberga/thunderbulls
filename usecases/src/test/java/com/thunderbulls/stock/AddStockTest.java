package com.thunderbulls.stock;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.output.AddStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public class AddStockTest {

	private AddStock add;

	@Before
	public void initialize() {
		add = new AddStock();
		add.setRepository(new MockStockRepository());
		add.setOutput(new MockAddStockOutput());
		
		add.add(new Stock("VIVT4"));
	}

	@Test
	public void canExistentStockBeAdded() {
		ResponseModel<Stock> response = add.add(new Stock("VIVT4"));
		assertNotNull(response.getErrors().get(0));
	}

	@Test
	public void canAddNewStock() {
		ResponseModel<Stock> response = add.add(new Stock("RADL3"));
		assertNull(response.getErrors().get(0));
	}
}
