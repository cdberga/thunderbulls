package com.thunderbulls.stock;

import java.util.List;

public interface StockRepository {

	Stock findByCode(String code);
	
	Stock findById(int id);
	
	List<Stock> findByCorpName(String corpName);
}
