package com.thunderbulls.stock.repository;

import java.util.List;

import com.thunderbulls.stock.Stock;

public interface StockRepository extends Repository{

	Stock findByCode(String code);
	
	List<Stock> findByCorpName(String corpName);

	Stock save(Stock stock);

	List<Stock> findAll();
}
