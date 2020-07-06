package com.thunderbulls.adapter.data;

import java.util.ArrayList;
import java.util.List;

import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.repository.StockRepository;

public class StockDataAccess implements StockRepository {
	
	StockFileDatabase database;

	@Override
	public Stock findByCode(String code) {
		database = new StockFileDatabase();
		StockDataEntity data = database.findByCode(code);
		return toDomain(data);
	}

	@Override
	public List<Stock> findByCorpName(String corpName) {
		database = new StockFileDatabase();
		List<StockDataEntity> list = database.findByCorpName(corpName);
		List<Stock> stockList = new ArrayList<Stock>();
		list.stream()
				.forEach(item -> stockList.add(toDomain(item)));
		return stockList;
	}

	@Override
	public Stock save(Stock stock) {
		database = new StockFileDatabase();
		database.save(toDataEntity(stock));
		return stock;
	}

	public StockDataEntity toDataEntity(Stock stock) {
		return new StockDataEntity(stock.getCode(), stock.getCompanyName());
	}
	
	private Stock toDomain(StockDataEntity dataEntity) {
		return new Stock(dataEntity.getCode(), dataEntity.getCompany());
	}

}
