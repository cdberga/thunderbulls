package com.thunderbulls.adapter.presenter;

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.adapter.view.StockViewModel;
import com.thunderbulls.stock.Stock;

public class StockFindPresenterTest {

	@Test
	public void createResponseOnNullStock() {
		StockFindPresenter p = new StockFindPresenter();
		ResponseModel<Stock> response = p.createResponse(null, "test");
		assertNull(response.getObject());
	}
		
	@Test
	public void createResponseOnNullStockList() {
		StockFindPresenter p = new StockFindPresenter();
		ResponseModel<List<Stock>> rm = p.createListResponse(null, null);
		assertNull(rm.getObject());
	}
	
	@Test
	public void viewModelFromNullResponse() {
		StockFindPresenter p = new StockFindPresenter();
		StockViewModel vm = p.toViewModel(null);
		assertNull(vm);

	}
	
	@Test
	public void viewModelFromNullResponseList() {
		StockFindPresenter p = new StockFindPresenter();
		List<StockViewModel> list = p.toViewModelList(null);
		assertNull(list);
	}
}
