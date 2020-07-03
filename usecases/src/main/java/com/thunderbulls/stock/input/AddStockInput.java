package com.thunderbulls.stock.input;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.output.AddStockOutput;

public interface AddStockInput {

	ResponseModel<Stock> add(Stock stock);
	
	void setOutput(AddStockOutput output);
}
