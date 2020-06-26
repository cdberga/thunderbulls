package com.thunderbulls.stock;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.UseCase;
import com.thunderbulls.stock.repository.StockRepository;
import com.thunderbulls.stock.request.AddStockInput;

public class AddStock extends UseCase<StockRepository> implements AddStockInput {

	public AddStock() {
	}

	public AddStock(StockRepository stockRepository) {
		super(stockRepository);
	}

	public ResponseModel<Stock> add(Stock stock) {
		ResponseModel<Stock> response = null;
		try {
			Stock s = repository.findByCode(stock.getCode());
			response = new ResponseModel<Stock>(s, null);
			if (s != null)
				throw new IllegalArgumentException("Stock \"" + stock.getCode() + "\" already exists.");
		} catch (Exception e) {
			response.setObject(null);
			response.setError(e);
		}
		return response;
	}

}
