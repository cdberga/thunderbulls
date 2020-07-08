package com.thunderbulls.stock;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.mock.MockAddStockOutput;
import com.thunderbulls.stock.mock.MockStockRepository;

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
		assertTrue(response.getErrors().size() == 0);
	}
	
	
	@Test
	public void canFindWithNoOutput() {
		add.setOutput(null);
		ResponseModel<Stock> response = add.add(new Stock("BAAA1"));
		assertTrue(response.getErrors().size() == 1);
	}
	
	@Test
	public void canFindWithNoRepository() {
		add.setRepository(null);
		ResponseModel<Stock> response = add.add(new Stock("BAAA1"));
		assertTrue(response.getErrors().size() == 1);
	}
}
