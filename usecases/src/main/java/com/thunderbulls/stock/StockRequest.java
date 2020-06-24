package com.thunderbulls.stock;

import java.util.List;

public interface StockRequest {

	Stock findByCode(String code);
	
	Stock findById(int id);
	
	List<Stock> findByCorpName(String corpName);
}
