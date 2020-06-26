package com.thunderbulls.stock.request;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;

public interface FindStockInput {

	ResponseModel<Stock> findByCode(String code);
	
	ResponseModel<List<Stock>> findByCorpName(String corpName);
}
