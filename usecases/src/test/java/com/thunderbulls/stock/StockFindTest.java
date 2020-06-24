package com.thunderbulls.stock;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class FindStockTest {

	@Test
	public void notFoundCodeAAAA1(){
		FindStock stock = new FindStock();
		assertNull("Stock AAAA1 not found", stock.findByCode("AAAA1"));
    }

}
