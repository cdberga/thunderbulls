package com.thunderbulls.adapter.data;

import java.util.List;

public interface StockDatabase {
	
	StockDataEntity findByCode(String code);
	
	List<StockDataEntity> findByCompany(String company);
	
	StockDataEntity save(StockDataEntity dataEntity);

	List<StockDataEntity> findAll();

}
