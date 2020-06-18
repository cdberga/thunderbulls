package com.thunderbulls.stock;

import org.junit.Test;

public class FindStockTest {

	@Test
	public void notFoundByCode(){
		FindStock stock = new FindStock();
		stock.findByCode("AAAA1");
    }

}
