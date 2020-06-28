package com.thunderbulls.stock.output;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;

public interface FindStockOutput {

	ResponseModel<List<Stock>> getListResponse(List<Stock> object, String errorMessage);
	
	ResponseModel<Stock> getResponse(Stock object, String errorMessage);
}
