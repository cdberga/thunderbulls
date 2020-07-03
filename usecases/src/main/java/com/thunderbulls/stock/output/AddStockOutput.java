package com.thunderbulls.stock.output;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;

public interface AddStockOutput {

	ResponseModel<Stock> createResponse(Stock stock, String error);
}
