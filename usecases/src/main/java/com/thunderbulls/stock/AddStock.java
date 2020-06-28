package com.thunderbulls.stock;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.UseCase;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.output.AddStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public class AddStock extends UseCase<StockRepository, Stock> implements AddStockInput {

	AddStockOutput output;
	
	public AddStock() {
		super();
	}

	public ResponseModel<Stock> add(Stock stock) {
		Stock s = repository.findByCode(stock.getCode());

		if (s != null) {
			return createResponse(stock, "Stock \"" + stock.getCode() + "\" already exists.");
		}

		return createResponse(repository.save(stock), null);
	}

	@Override
	public ResponseModel<Stock> createResponse(Stock object, String error) {
		return output.getResponse(object, error);
	}

	public void setOutput(AddStockOutput output) {
		this.output = output;
	}

}

