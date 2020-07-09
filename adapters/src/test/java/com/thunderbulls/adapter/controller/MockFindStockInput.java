package com.thunderbulls.adapter.controller;

import java.util.Arrays;
import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.FindStockInput;
import com.thunderbulls.stock.output.FindStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public class MockFindStockInput implements FindStockInput {

	public MockFindStockInput() {
	}

	public ResponseModel<Stock> findByCode(String code) {
		return new ResponseModel<Stock>(new Stock(code), null);
	}

	public ResponseModel<List<Stock>> findByCorpName(String corpName) {
		return null;
	}

	public void setOutput(FindStockOutput output) {
	}

	public void setRepository(StockRepository repository) {
	}

	@Override
	public ResponseModel<List<Stock>> findAll() {
		return new ResponseModel<List<Stock>>(Arrays.asList(new Stock("PETR4", "Petrobras"), new Stock("VALE5", "VALE SA")));
	}

}
