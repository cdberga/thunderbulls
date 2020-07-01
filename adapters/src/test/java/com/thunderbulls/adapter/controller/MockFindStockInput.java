package com.thunderbulls.adapter.controller;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.FindStockInput;

public class MockFindStockInput implements FindStockInput {

	public ResponseModel<Stock> findByCode(String code) {
		return createResponse(new Stock(code, "Petrobras"), null);
	}

	public ResponseModel<List<Stock>> findByCorpName(String corpName) {
		return null;
	}

	public ResponseModel<Stock> createResponse(Stock object, String errorMessage) {
		return new ResponseModel<Stock>(object, null);
	}
}
