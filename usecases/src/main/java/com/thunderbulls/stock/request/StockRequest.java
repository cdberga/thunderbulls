package com.thunderbulls.stock.request;

import java.util.List;

import com.thunderbulls.stock.Stock;

public interface StockRequest {

	Stock findByCode(String code);
	
	Stock findById(int id);
	
	List<Stock> findByCorpName(String corpName);
}
