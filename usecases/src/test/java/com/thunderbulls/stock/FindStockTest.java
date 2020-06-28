package com.thunderbulls.stock;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.output.FindStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public class FindStockTest {

	FindStock stockFinder;
	AddStock stockCreator;

	@Before
	public void initialize() {
		stockFinder = new FindStock();
		stockCreator = new AddStock();
		StockRepository sr = new MockStockRepository();

		stockFinder.setOutput(new MockFindStockOutput());
		stockFinder.setRepository(sr);
		stockCreator.setOutput(new MockAddStockOutput());
		stockCreator.setRepository(sr);

		stockCreator.add(new Stock("AAAA1", "AAAA Corp"));
		stockCreator.add(new Stock("PETR4", "Petrobras"));
		stockCreator.add(new Stock("PETR5", "Petrobras"));
	}

	@Test
	public void canFindStockByCode() {
		ResponseModel<Stock> response = stockFinder.findByCode("AAAA1");
		assertNull(response.getError().get(0));
	}

	@Test
	public void canFindStockByCorp() {
		ResponseModel<List<Stock>> response = stockFinder.findByCorpName("Petrobras");
		List<Stock> list = response.getObject();
		assertTrue(list.size() == 2);
	}
}
