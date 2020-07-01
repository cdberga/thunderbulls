package com.thunderbulls.adapter.controller;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.UseCase;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.repository.StockRepository;

public class MockAddStockInput implements AddStockInput {

	public ResponseModel<Stock> add(Stock stock) {
		return createResponse(stock, null);
	}

	public ResponseModel<Stock> createResponse(Stock object, String errorMessage) {
		return new ResponseModel<Stock>(object);
	}

}
