package com.thunderbulls.stock;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.stock.repository.StockRepository;

public class FindStockTest {

	FindStock finder;

	@Before
	public void initialize() {
		finder = new FindStock();
		StockRepository sr = new MockStockRepository();
		finder.setRepository(sr);
	}

	@Test
	public void canFindStockByCode() {
		assertNotNull(finder.findByCode("AAAA1"));
	}

	@Test
	public void canFindStockByCorp() {
		assertTrue(finder.findByCorpName("Petrobras").size() == 2);
	}
}
