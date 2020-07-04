package com.thunderbulls.adapter.controller;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.adapter.view.StockViewModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.input.FindStockInput;

public class StockController {
	
	// TODO: include view classes
	//	TODO: Change toViewModel method to Presenter class

	private FindStockInput findStock;
	private AddStockInput addStock;

	public StockViewModel findStock(String code) {
		ResponseModel<Stock> response = findStock.findByCode(code);
		if(response.getErrors().size() == 0)
			return toViewModel(response);

		return null;
	}
	
	public StockViewModel save(String code, String company) {
		ResponseModel<Stock> response = addStock.add(new Stock(code, company));
		if(response.getErrors().size() == 0)
			return toViewModel(response);

		return null;

	}

	private StockViewModel toViewModel(ResponseModel<Stock> response) {
		StockViewModel viewModel = new StockViewModel();
		viewModel.setCode(response.getObject().getCode());
		viewModel.setCompany(response.getObject().getCompanyName());
		return viewModel;
	}
	
	public void setStockFinderInput(FindStockInput finder) {
		this.findStock = finder;
	}
	
	public void setStockAddInput(AddStockInput add) {
		this.addStock = add;
	}

}
