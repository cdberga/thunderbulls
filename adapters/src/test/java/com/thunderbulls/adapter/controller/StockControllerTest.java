package com.thunderbulls.adapter.controller;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.stock.MockAddStockOutput;
import com.thunderbulls.stock.MockFindStockOutput;
import com.thunderbulls.stock.MockStockRepository;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.input.FindStockInput;

public class StockControllerTest {
	
	StockController controller;

	AddStockInput addStock;
	FindStockInput findStock;
	
	@Before
	public void initialize() {
		controller = new StockController();
		addStock = new MockAddStockInput(new MockAddStockOutput(), new MockStockRepository());
		findStock = new MockFindStockInput(new MockFindStockOutput(), new MockStockRepository());

		controller.setStockAddInput(addStock);
		controller.setStockFinderInput(findStock);

		controller.save("PETR4", "Petrobras");
	}

	@Test
	public void findStockByCode() {
//		StockOutputData outputData = controller.findStock("PETR4");
//		assertNotNull(outputData);
//		assertTrue(outputData.getCode().equals("PETR4"));
	}

}
