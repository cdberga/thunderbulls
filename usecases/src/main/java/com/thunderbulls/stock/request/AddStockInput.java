package com.thunderbulls.stock.request;

import com.thunderbulls.stock.Stock;

public interface AddStockInput{

	Stock add(Stock stock) throws IllegalArgumentException;
}
