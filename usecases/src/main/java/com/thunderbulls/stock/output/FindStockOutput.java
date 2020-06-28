package com.thunderbulls.stock.output;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;

public interface FindStockOutput {

	ResponseModel<List<Stock>> getListResponse();
	
	ResponseModel<Stock> getResponse();

	void setListResponse(ResponseModel<List<Stock>> response);
	
	void setResponse(ResponseModel<Stock> response);
}
