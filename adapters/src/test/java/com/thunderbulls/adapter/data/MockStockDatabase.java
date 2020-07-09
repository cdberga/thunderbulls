package com.thunderbulls.adapter.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MockStockDatabase implements StockDatabase{
	
	List<StockDataEntity> stockList = new ArrayList<StockDataEntity>();
	
	@Override
	public StockDataEntity findByCode(String code) {
		StockDataEntity check = stockList.stream()
					.filter(stock -> code.equals(stock.getCode()))
					.findAny()
					.orElse(null);
		return check;
	}

	@Override
	public List<StockDataEntity> findByCompany(String corpName) {
		List<StockDataEntity> list = (List<StockDataEntity>) stockList.stream()
				.filter(stock -> stock.getCompany().equals(stock.getCompany()))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public StockDataEntity save(StockDataEntity stock) {
		stockList.add(stock);
		return stock;
	}

	@Override
	public List<StockDataEntity> findAll() {
		return stockList;
	}
}
