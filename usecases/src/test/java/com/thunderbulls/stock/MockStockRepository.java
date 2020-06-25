package com.thunderbulls.stock;

import java.util.Arrays;
import java.util.List;

import com.thunderbulls.stock.repository.StockRepository;

public class MockStockRepository implements StockRepository {

	private List<Stock> stockList;

	public Stock findByCode(String code) {
		return new Stock(code);
	}

	public List<Stock> findByCorpName(String corpName) {
		List<Stock> list = Arrays.asList(new Stock("PETR4"), new Stock("PETR5"));
		return list;
	}

}
