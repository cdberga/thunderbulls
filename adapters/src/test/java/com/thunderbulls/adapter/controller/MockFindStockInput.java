package com.thunderbulls.adapter.controller;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.FindStockInput;
import com.thunderbulls.stock.output.FindStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public class MockFindStockInput implements FindStockInput {

	FindStockOutput output;
	StockRepository repository;
	
	public MockFindStockInput(FindStockOutput findOutput, StockRepository repository) {
		setOutput(findOutput);
		setRepository(repository);
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

	public void setRepository(StockRepository repository) {
		this.repository = repository;
	}
}
