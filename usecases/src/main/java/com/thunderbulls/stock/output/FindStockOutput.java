package com.thunderbulls.stock.output;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;

public interface FindStockOutput {

	ResponseModel<Stock> createResponse(Stock stock, String error);

	ResponseModel<List<Stock>> createResponse(List<Stock> list, String error);

}
