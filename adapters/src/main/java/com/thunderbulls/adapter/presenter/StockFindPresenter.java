package com.thunderbulls.adapter.presenter;

import java.util.ArrayList;
import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.adapter.view.StockViewModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.output.FindStockOutput;

public class StockFindPresenter implements FindStockOutput{

	public ResponseModel<Stock> createResponse(Stock stock, String error) {
		return new ResponseModel<Stock>(stock, error);
	}

	public ResponseModel<List<Stock>> createResponse(List<Stock> list, String error) {
		return new ResponseModel<List<Stock>>(list, error);
	}

	public StockViewModel toViewModel(ResponseModel<Stock> response) {
		return new StockViewModel(response.getObject().getCode(), response.getObject().getCompanyName());
	}
	
	public List<StockViewModel> toViewModelList(ResponseModel<List<Stock>> response) {
		List<StockViewModel> list = new ArrayList<StockViewModel>();
		response.getObject().stream()
				.forEach(stock -> list.add(
						new StockViewModel(stock.getCode(), stock.getCompanyName())
						)
				);
		return list;
	}
}
