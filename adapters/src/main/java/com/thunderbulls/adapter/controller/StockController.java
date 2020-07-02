package com.thunderbulls.adapter.controller;

import com.thunderbulls.ResponseModel;
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
	
	public StockOutputData save(StockOutputData outputData) {
		ResponseModel<Stock> response = addStock.add(toEntity(outputData));
		if(response.getErrors().size() == 0)
			return toOutputData(response);

		return null;

	}

	private StockOutputData toOutputData(ResponseModel<Stock> response) {
		StockOutputData outputData = new StockOutputData();
		outputData.setCode(response.getObject().getCode());
		outputData.setCompany(response.getObject().getCompanyName());
		return outputData;
	}
	
	private Stock toEntity(StockOutputData outputData) {
		Stock entity = new Stock(outputData.getCode());
		entity.setCompanyName(outputData.getCompany());
		return entity;
	}
	
	public void setStockFinderInput(FindStockInput finder) {
		this.findStock = finder;
	}
	
	public void setStockAddInput(AddStockInput add) {
		this.addStock = add;
	}
}
