package com.thunderbulls.stock.request;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;

public interface AddStockInput{

	ResponseModel<Stock> add(Stock stock) throws IllegalArgumentException;
}
