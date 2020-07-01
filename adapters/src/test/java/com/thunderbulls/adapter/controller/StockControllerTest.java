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

		StockViewModel viewModel = new StockViewModel();
		viewModel.setCode("PETR4");
		viewModel.setCompany("Petrobras");
		controller.save(viewModel);
	}

	@Test
	public void findStockByCode() {
		StockViewModel viewModel = controller.findStock("PETR4");
		assertNotNull(viewModel);
		assertTrue(viewModel.getCode().equals("PETR4"));
	}

}
