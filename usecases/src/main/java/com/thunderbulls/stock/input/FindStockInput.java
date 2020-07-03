package com.thunderbulls.stock.input;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.output.FindStockOutput;

public interface FindStockInput {

	ResponseModel<Stock> findByCode(String code);
	
	ResponseModel<List<Stock>> findByCorpName(String corpName);
	
	void setOutput(FindStockOutput output);
}
