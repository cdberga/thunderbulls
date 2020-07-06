package com.thunderbulls.adapter.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.repository.StockRepository;

public class MockStockDataAccess implements StockRepository{
	
	List<Stock> stockList = new ArrayList<Stock>();
	
	@Override
	public Stock findByCode(String code) {
		Stock check = stockList.stream()
					.filter(stock -> code.equals(stock.getCode()))
					.findAny()
					.orElse(null);
		return check;
	}

	@Override
	public List<Stock> findByCorpName(String corpName) {
		List<Stock> list = Arrays.asList(new Stock("PETR4"), new Stock("PETR5"));
		return list;
	}

	@Override
	public Stock save(Stock stock) {
		stockList.add(stock);
		return stock;
	}
}
