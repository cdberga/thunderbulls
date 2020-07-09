package com.thunderbulls.adapter.data;

import java.util.ArrayList;
import java.util.List;

import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.repository.StockRepository;

public class StockDataAccess implements StockRepository {
	
	public StockDataAccess() {
		super();
		this.database = new StockFileDatabase();
	}
	
	public StockDataAccess(StockDatabase database) {
		super();
		this.setDatabase(database);
	}

	StockDatabase database;

	@Override
	public Stock findByCode(String code) {
		StockDataEntity data = database.findByCode(code);
		return toDomain(data);
	}

	@Override
	public List<Stock> findByCorpName(String corpName) {
		List<StockDataEntity> list = database.findByCompany(corpName);
		List<Stock> stockList = new ArrayList<Stock>();
		list.stream()
				.forEach(item -> stockList.add(toDomain(item)));
		return stockList;
	}

	@Override
	public Stock save(Stock stock) {
		database.save(toDataEntity(stock));
		return stock;
	}

	public StockDataEntity toDataEntity(Stock stock) {
		if(stock == null)
			return null;
		
		return new StockDataEntity(stock.getCode(), stock.getCompanyName());
	}
	
	private Stock toDomain(StockDataEntity dataEntity) {
		if(dataEntity == null)
			return null;
		
		return new Stock(dataEntity.getCode(), dataEntity.getCompany());
	}

	public void setDatabase(StockDatabase database) {
		this.database = database;
	}

}
