package com.thunderbulls.adapter.presenter;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.adapter.view.StockViewModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.output.AddStockOutput;

public class StockAddPresenter implements AddStockOutput{

	public ResponseModel<Stock> createResponse(Stock object, String errorMessage) {
		return new ResponseModel<Stock>(object, errorMessage);
	}
	
	public ResponseModel<List<Stock>> createResponse(List<Stock> list, String error) {
		return null;
	}
}
