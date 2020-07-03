package com.thunderbulls.adapter.presenter;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.output.AddStockOutput;

public class StockAddPresenter implements AddStockOutput{

	public ResponseModel<Stock> createResponse(Stock object, String errorMessage) {
		return new ResponseModel<Stock>(object, errorMessage);
	}

}
