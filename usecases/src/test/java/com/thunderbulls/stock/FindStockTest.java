package com.thunderbulls.stock;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.repository.StockRepository;

public class FindStockTest {

	FindStock finder;

	@Before
	public void initialize() {
		finder = new FindStock();
		StockRepository sr = new MockStockRepository();
		sr.save(new Stock("AAAA1", "AAAA Corp"));
		sr.save(new Stock("PETR4", "Petrobras"));
		sr.save(new Stock("PETR5", "Petrobras"));
		finder.setRepository(sr);
	}

	@Test
	public void canFindStockByCode() {
		ResponseModel<Stock> response = finder.findByCode("AAAA1");
		assertNull(response.getError());
	}

	@Test
	public void canFindStockByCorp() {
		ResponseModel<List<Stock>> response = finder.findByCorpName("Petrobras");
		List<Stock> list = response.getObject();
		assertTrue(list.size() == 2);
	}
}
