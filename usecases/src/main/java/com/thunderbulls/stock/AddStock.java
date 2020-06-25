package com.thunderbulls.stock;

import com.thunderbulls.UseCase;
import com.thunderbulls.stock.repository.StockRepository;
import com.thunderbulls.stock.request.AddStockRequest;

public class AddStock extends UseCase<StockRepository> implements AddStockRequest {

	public AddStock() {
	}
	
	public AddStock(StockRepository stockRepository) {
		super(stockRepository);
	}

	public Stock add(Stock stock) {
		Stock s = repository.findByCode(stock.getCode());
		if(s != null)
			throw new IllegalArgumentException("Stock \"" + stock.getCode() +  "\" already exists.");
		
		return repository.save(stock);
	}

}
