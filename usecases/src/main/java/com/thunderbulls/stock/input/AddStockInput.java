package com.thunderbulls.stock.input;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;

public interface AddStockInput{

	ResponseModel<Stock> add(Stock stock);
}
