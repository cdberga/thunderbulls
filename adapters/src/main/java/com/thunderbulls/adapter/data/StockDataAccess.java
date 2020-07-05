package com.thunderbulls.adapter.data;

import java.util.List;

import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.repository.StockRepository;

public class StockDataAccess implements StockRepository {

	@Override
	public Stock findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stock> findByCorpName(String corpName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock save(Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}

	public StockDataEntity toDataEntity(Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}

}
