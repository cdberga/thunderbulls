package com.thunderbulls.stock;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.output.AddStockOutput;

public class MockAddStockOutput implements AddStockOutput {

	@Override
	public ResponseModel<Stock> createResponse(Stock stock, String error) {
		return new ResponseModel<Stock>(stock, error);
	}

}
