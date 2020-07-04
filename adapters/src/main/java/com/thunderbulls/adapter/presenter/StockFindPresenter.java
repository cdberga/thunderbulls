package com.thunderbulls.adapter.presenter;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.output.FindStockOutput;

public class StockFindPresenter implements FindStockOutput{

	public ResponseModel<Stock> createResponse(Stock stock, String error) {
		return new ResponseModel<Stock>(stock, error);
	}

	public ResponseModel<List<Stock>> createResponse(List<Stock> list, String error) {
		return null;
	}

}
