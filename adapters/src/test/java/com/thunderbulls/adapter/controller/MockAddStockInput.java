package com.thunderbulls.adapter.controller;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.output.AddStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public class MockAddStockInput implements AddStockInput {

	AddStockOutput output;
	StockRepository repository;
	
	public MockAddStockInput(AddStockOutput addOutput, StockRepository repository) {
		setOutput(addOutput);
		setRepository(repository);
	}

	public ResponseModel<Stock> add(Stock stock) {
		return output.createResponse(stock, null);
	}

	public void setOutput(AddStockOutput output) {
		this.output = output;
	}

	public void setRepository(StockRepository repository) {
		this.repository = repository;
	}

}
