package com.thunderbulls.adapter.controller;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.adapter.view.StockOutputData;
import com.thunderbulls.stock.AddStock;
import com.thunderbulls.stock.FindStock;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.input.FindStockInput;

public class StockController {

	private FindStockInput findStock;
	private AddStockInput addStock;

	public StockOutputData findStock(String code) {
		ResponseModel<Stock> response = findStock.findByCode(code);
		if(response.getErrors().size() == 0)
			return toOutputData(response);

		return null;
	}
	
	public StockOutputData save(StockOutputData viewModel) {
		ResponseModel<Stock> response = addStock.add(toEntity(viewModel));
		if(response.getErrors().size() == 0)
			return toOutputData(response);

		return null;

	}

	private StockOutputData toOutputData(ResponseModel<Stock> response) {
		StockOutputData viewModel = new StockOutputData();
		viewModel.setCode(response.getObject().getCode());
		viewModel.setCompany(response.getObject().getCompanyName());
		return viewModel;
	}
	
	private Stock toEntity(StockOutputData viewModel) {
		Stock entity = new Stock(viewModel.getCode());
		entity.setCompanyName(viewModel.getCompany());
		return entity;
	}
	
	public void setStockFinderInput(FindStockInput find) {
		this.findStock = find;
	}
	
	public void setStockAddInput(AddStockInput add) {
		this.addStock = add;
	}
}
