package com.thunderbulls.adapter.controller;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.FindStockInput;
import com.thunderbulls.stock.output.FindStockOutput;

public class MockFindStockInput implements FindStockInput {

	FindStockOutput output;
	
	public MockFindStockInput(FindStockOutput findOutput) {
		setOutput(findOutput);
	}

	public ResponseModel<Stock> findByCode(String code) {
		return output.createResponse(new Stock(code, "Petrobras"), null);
	}

	public ResponseModel<List<Stock>> findByCorpName(String corpName) {
		return null;
	}

	public ResponseModel<Stock> createResponse(Stock object, String errorMessage) {
		return new ResponseModel<Stock>(object, null);
	}

	public void setOutput(FindStockOutput output) {
		this.output = output;
	}
}
