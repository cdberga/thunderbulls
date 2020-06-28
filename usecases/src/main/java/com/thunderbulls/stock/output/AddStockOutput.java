package com.thunderbulls.stock.output;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;

public interface AddStockOutput {

	ResponseModel<Stock> getResponse(Stock s, String errorMessage);
}
