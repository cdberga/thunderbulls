package com.thunderbulls.stock.request;

import java.util.List;

import com.thunderbulls.stock.Stock;

public interface FindStockRequest {

	Stock findByCode(String code);
	
	List<Stock> findByCorpName(String corpName);
}
