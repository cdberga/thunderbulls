package com.thunderbulls.adapter.view;

public class StockView {

	StockViewModel viewModel;
	
	public StockView(StockViewModel viewModel) {
		this.viewModel = viewModel;
	}

	public StockViewModel getViewModel() {
		return viewModel;
	}

	public void setViewModel(StockViewModel viewModel) {
		this.viewModel = viewModel;
	}

}
