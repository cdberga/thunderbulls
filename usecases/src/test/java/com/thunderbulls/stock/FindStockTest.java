package com.thunderbulls.stock;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.mock.MockAddStockOutput;
import com.thunderbulls.stock.mock.MockFindStockOutput;
import com.thunderbulls.stock.mock.MockStockRepository;
import com.thunderbulls.stock.repository.StockRepository;

public class FindStockTest {
	FindStock stockFinder;
	AddStock stockCreator;

	@Before
	public void initialize() {
		stockFinder = new FindStock();
		stockCreator = new AddStock();
		StockRepository sr = new MockStockRepository();

		stockFinder.setRepository(sr);
		stockCreator.setRepository(sr);
		
		stockFinder.setOutput(new MockFindStockOutput());
		stockCreator.setOutput(new MockAddStockOutput());

		stockCreator.add(new Stock("AAAA1", "AAAA Corp"));
		stockCreator.add(new Stock("PETR4", "Petrobras"));
		stockCreator.add(new Stock("PETR5", "Petrobras"));
	}

	@Test
	public void canFindStockByCode() {
		ResponseModel<Stock> response = stockFinder.findByCode("AAAA1");
		assertTrue(response.getErrors().size() == 0);
	}

	@Test
	public void canFindStockByCorp() {
		ResponseModel<List<Stock>> response = stockFinder.findByCorpName("Petrobras");
		List<Stock> list = response.getObject();
		assertTrue(list.size() == 2);
	}
	
	@Test
	public void canFindWithNoOutput() {
		stockFinder.setOutput(null);
		ResponseModel<Stock> response = stockFinder.findByCode("AAAA1");
		assertTrue(response.getErrors().size() == 1);
	}
	
	@Test
	public void canFindWithNoRepository() {
		stockFinder.setRepository(null);
		ResponseModel<Stock> response = stockFinder.findByCode("AAAA1");
		assertTrue(response.getErrors().size() == 1);
	}
	
	@Test
	public void canFindAll() {
		ResponseModel<List<Stock>> response = stockFinder.findAll();
		assertTrue(response.getErrors().size() == 0);
		assertTrue(response.getObject().size() > 0);
	}
}
