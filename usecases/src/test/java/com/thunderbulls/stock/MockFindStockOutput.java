package com.thunderbulls.stock;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.output.FindStockOutput;

public class MockFindStockOutput implements FindStockOutput {

	ResponseModel<List<Stock>> listResponse;
	ResponseModel<Stock> response;
	
	@Override
	public ResponseModel<List<Stock>> getListResponse(List<Stock> object, String errorMessage) {
		return new ResponseModel<List<Stock>>(object, errorMessage);
	}

	@Override
	public ResponseModel<Stock> getResponse(Stock object, String errorMessage) {
		return new ResponseModel<Stock>(object, errorMessage);
	}

}
