package com.thunderbulls.adapter.controller;

import java.util.ArrayList;
import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.output.AddStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public class MockAddStockInput implements AddStockInput {

	List<Stock> list;
	
	public MockAddStockInput() {
		list = new ArrayList<Stock>();
	}

	public ResponseModel<Stock> add(Stock stock) {
		if(list.contains(stock))
			return new ResponseModel<Stock>(null, "Stock " + stock.getCode() + " already exists.");

		list.add(stock);
		return new ResponseModel<Stock>(stock, null);
	}

	public void setOutput(AddStockOutput output) {
		
	}

	public void setRepository(StockRepository repository) {
		
	}

}
