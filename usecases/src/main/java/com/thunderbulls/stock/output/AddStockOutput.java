package com.thunderbulls.stock.output;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;

public interface AddStockOutput {

	void setResponse(ResponseModel<Stock> response);

	ResponseModel<Stock> getResponse();
}
