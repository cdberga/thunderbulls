package com.thunderbulls.adapter.controller;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.adapter.presenter.StockAddPresenter;
import com.thunderbulls.adapter.presenter.StockFindPresenter;
import com.thunderbulls.adapter.view.StockView;
import com.thunderbulls.stock.AddStock;
import com.thunderbulls.stock.FindStock;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.input.FindStockInput;

public class StockController {
	
	public StockController() {
		super();
		findPresenter = new StockFindPresenter();
		addPresenter = new StockAddPresenter();
		findStock = new FindStock();
		addStock = new AddStock();

		findStock.setOutput(findPresenter);
		addStock.setOutput(addPresenter);
	}

	public StockController(FindStockInput findInput, AddStockInput addInput) {
		super();
		findPresenter = new StockFindPresenter();
		addPresenter = new StockAddPresenter();
		findStock = findInput;
		addStock = addInput;

		findStock.setOutput(findPresenter);
		addStock.setOutput(addPresenter);
	}

	private FindStockInput findStock;
	private AddStockInput addStock;
	private StockFindPresenter findPresenter;
	private StockAddPresenter addPresenter;

	public StockView findStock(String code) {
		ResponseModel<Stock> response = findStock.findByCode(code);
		return getStockView(response);
	}

	public StockView save(String code, String company) {
		ResponseModel<Stock> response = addStock.add(new Stock(code, company));
		if(response.getErrors().size() == 0)
			return new StockView(addPresenter.toViewModel(response));
		
		return null;
		
	}
	
	private StockView getStockView(ResponseModel<Stock> response) {
		if(response.getErrors().size() == 0) {
			return new StockView(findPresenter.toViewModel(response));
		}
		
		return null;
	}
	
	public void setStockFinderInput(FindStockInput finder) {
		this.findStock = finder;
	}
	
	public void setStockAddInput(AddStockInput add) {
		this.addStock = add;
	}

}
