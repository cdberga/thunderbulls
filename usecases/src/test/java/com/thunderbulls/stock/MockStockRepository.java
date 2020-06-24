package com.thunderbulls.stock;

import java.util.Arrays;
import java.util.List;

public class MockStockRepository implements StockRepository {

	public Stock findByCode(String code) {
		return new Stock(code);
	}

	public Stock findById(int id) {
		return new Stock(id);
	}

	public List<Stock> findByCorpName(String corpName) {
		List<Stock> list = Arrays.asList(new Stock("PETR4"), new Stock("PETR5"));
		return list;
	}

}
