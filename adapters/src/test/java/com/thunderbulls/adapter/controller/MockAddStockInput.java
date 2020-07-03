package com.thunderbulls.adapter.controller;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.output.AddStockOutput;

public class MockAddStockInput implements AddStockInput {

	AddStockOutput output;
	
	public MockAddStockInput(AddStockOutput addOutput) {
		this.setOutput(addOutput);
	}

	public ResponseModel<Stock> add(Stock stock) {
		return output.createResponse(stock, null);
	}

	public void setOutput(AddStockOutput output) {
		this.output = output;
	}

}
