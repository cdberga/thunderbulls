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

		StockOutputData viewModel = new StockOutputData();
		viewModel.setCode("PETR4");
		viewModel.setCompany("Petrobras");
		controller.save(viewModel);
	}

	@Test
	public void findStockByCode() {
		StockOutputData viewModel = controller.findStock("PETR4");
		assertNotNull(viewModel);
		assertTrue(viewModel.getCode().equals("PETR4"));
	}

}
