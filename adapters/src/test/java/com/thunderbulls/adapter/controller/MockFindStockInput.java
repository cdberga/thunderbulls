package com.thunderbulls.adapter.controller;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.input.FindStockInput;

public class MockFindStockInput implements FindStockInput {

	public ResponseModel<Stock> findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseModel<List<Stock>> findByCorpName(String corpName) {
		// TODO Auto-generated method stub
		return null;
	}

}
