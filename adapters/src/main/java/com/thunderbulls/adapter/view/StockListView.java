package com.thunderbulls.adapter.view;

import java.util.List;

public class StockListView {

	public StockListView(List<StockViewModel> list) {
		super();
		this.list = list;
	}

	List<StockViewModel> list;

	public List<StockViewModel> getList() {
		return list;
	}

	public void setList(List<StockViewModel> list) {
		this.list = list;
	}
}
