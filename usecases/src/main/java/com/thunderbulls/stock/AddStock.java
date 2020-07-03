package com.thunderbulls.stock;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.UseCase;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.output.AddStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public class AddStock extends UseCase<StockRepository> implements AddStockInput {

	private AddStockOutput output;

	public AddStock() {
		super();
	}

	public ResponseModel<Stock> add(Stock stock) {
		Stock s = repository.findByCode(stock.getCode());

		if (s != null) {
			return output.createResponse(stock, "Stock \"" + stock.getCode() + "\" already exists.");
		}

		return output.createResponse(repository.save(stock), null);
	}

	@Override
	public void setOutput(AddStockOutput output) {
		this.output = output;
	}
}

