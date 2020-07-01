package com.thunderbulls.adapter.presenter;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.output.FindStockOutput;
import com.thunderbulls.stock.Stock;

public class StockPresenter implements FindStockOutput {

	public ResponseModel<List<Stock>> getListResponse(List<Stock> object, String errorMessage) {
		return null;
	}

	public ResponseModel<Stock> getResponse(Stock object, String errorMessage) {
		return null;
	}

}
