package com.thunderbulls.adapter.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.adapter.view.StockOutputData;
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

		StockOutputData outputData = new StockOutputData();
		outputData.setCode("PETR4");
		outputData.setCompany("Petrobras");
		controller.save(outputData);
	}

	@Test
	public void findStockByCode() {
		StockOutputData outputData = controller.findStock("PETR4");
		assertNotNull(outputData);
		assertTrue(outputData.getCode().equals("PETR4"));
	}

}
