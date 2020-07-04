package com.thunderbulls.adapter.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.adapter.view.StockViewModel;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.input.FindStockInput;

public class StockControllerTest {
	
	StockController controller;

	AddStockInput addStock;
	FindStockInput findStock;
	
	@Before
	public void initialize() {
		controller = new StockController();
		addStock = new MockAddStockInput();
		findStock = new MockFindStockInput();

		controller.setStockAddInput(addStock);
		controller.setStockFinderInput(findStock);

		controller.save("PETR4", "Petrobras");
	}

	@Test
	public void findStockByCode() {
		StockViewModel stockView = controller.findStock("PETR4");
		assertNotNull(stockView);
		assertTrue(stockView.getCode().equals("PETR4"));
	}

}
