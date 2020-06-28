package com.thunderbulls.stock;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.output.AddStockOutput;

public class MockAddStockOutput implements AddStockOutput {

	@Override
	public ResponseModel<Stock> getResponse(Stock s, String errorMessage) {
		return new ResponseModel<Stock>(s, errorMessage);
	}

}
