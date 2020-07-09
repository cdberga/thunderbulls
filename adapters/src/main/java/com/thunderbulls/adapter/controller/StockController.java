package com.thunderbulls.adapter.controller;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.adapter.data.StockDataAccess;
import com.thunderbulls.adapter.presenter.StockAddPresenter;
import com.thunderbulls.adapter.presenter.StockFindPresenter;
import com.thunderbulls.adapter.view.StockListView;
import com.thunderbulls.adapter.view.StockView;
import com.thunderbulls.adapter.view.StockViewModel;
import com.thunderbulls.stock.AddStock;
import com.thunderbulls.stock.FindStock;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.input.FindStockInput;

public class StockController {
	
	private FindStockInput findStock;
	private AddStockInput addStock;
	private StockFindPresenter findPresenter;
	private StockAddPresenter addPresenter;

	public StockController() {
		super();
		initData(new FindStock(), new AddStock());
	}

	public StockController(FindStockInput findInput, AddStockInput addInput) {
		super();
		initData(findInput, addInput);
	}

	private void initData(FindStockInput findInput, AddStockInput addInput) {
		findPresenter = new StockFindPresenter();
		addPresenter = new StockAddPresenter();
		findStock = findInput;
		addStock = addInput;
		
		findStock.setOutput(findPresenter);
		addStock.setOutput(addPresenter);
		
		findStock.setRepository(new StockDataAccess());
		addStock.setRepository(new StockDataAccess());
	}


	public StockView findStock(String code) {
		ResponseModel<Stock> response = findStock.findByCode(code);
		return getStockView(response);
	}

	public StockView save(String code, String company) {
		ResponseModel<Stock> response = addStock.add(new Stock(code, company));
		if(response.getErrors().size() == 0)
			return new StockView(addPresenter.toViewModel(response));

		throw new RuntimeException(response.getErrors().get(0));
	}
	
	private StockView getStockView(ResponseModel<Stock> response) {
		if(response.getErrors().size() == 0) {
			return new StockView(findPresenter.toViewModel(response));
		}
		
		throw new RuntimeException(response.getErrors().get(0));
	}
	
	private StockListView getStockListView(ResponseModel<List<Stock>> response) {
		List<StockViewModel> list;
		if(response.getErrors().size() == 0) {
			list = findPresenter.toViewModelList(response);
			return new StockListView(list);
		}
		
		throw new RuntimeException(response.getErrors().get(0));
	}
	
	public void setStockFinderInput(FindStockInput finder) {
		this.findStock = finder;
	}
	
	public void setStockAddInput(AddStockInput add) {
		this.addStock = add;
	}

	public StockListView findAll() {
		ResponseModel<List<Stock>> response = findStock.findAll();
		return getStockListView(response);
	}

}
