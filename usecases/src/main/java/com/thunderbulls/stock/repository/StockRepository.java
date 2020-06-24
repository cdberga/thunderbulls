package com.thunderbulls.stock.repository;

import java.util.List;

import com.thunderbulls.stock.Stock;

public interface StockRepository {

	Stock findByCode(String code);
	
	Stock findById(int id);
	
	List<Stock> findByCorpName(String corpName);
}
