package com.thunderbulls.stock.request;

import com.thunderbulls.stock.Stock;

public interface AddStockRequest {

	Stock add(Stock stock) throws IllegalArgumentException;
}
