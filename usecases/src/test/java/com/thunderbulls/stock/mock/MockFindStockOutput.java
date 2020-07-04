package com.thunderbulls.stock.mock;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.output.FindStockOutput;

public class MockFindStockOutput implements FindStockOutput {

	@Override
	public ResponseModel<Stock> createResponse(Stock stock, String error) {
		return new ResponseModel<Stock>(stock, error);
	}

	@Override
	public ResponseModel<List<Stock>> createResponse(List<Stock> list, String error) {
		return new ResponseModel<List<Stock>>(list, error);
	}

}
