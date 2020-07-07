package com.thunderbulls.adapter.presenter;

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.adapter.view.StockViewModel;
import com.thunderbulls.stock.Stock;

public class StockFindPresenterTest {

	StockFindPresenter presenter;
	
	@Before
	public void initialize() {
		presenter = new StockFindPresenter();
	}
	
	@Test
	public void createResponseOnNullStock() {
		ResponseModel<Stock> response = presenter.createResponse(null, "test");
		assertNull(response.getObject());
	}
		
	@Test
	public void createResponseOnNullStockList() {
		ResponseModel<List<Stock>> rm = presenter.createListResponse(null, null);
		assertNull(rm.getObject());
	}
	
	@Test
	public void viewModelFromNullResponse() {
		StockViewModel vm = presenter.toViewModel(null);
		assertNull(vm);
	}
	
	@Test
	public void viewModelFromNullResponseList() {
		List<StockViewModel> list = presenter.toViewModelList(null);
		assertNull(list);
	}
}
