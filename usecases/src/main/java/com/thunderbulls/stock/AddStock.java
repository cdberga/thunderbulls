package com.thunderbulls.stock;

import com.thunderbulls.stock.repository.StockRepository;
import com.thunderbulls.stock.request.AddStockRequest;

public class AddStock implements AddStockRequest {

	private StockRepository stockRepository;

	public void setRepository(StockRepository sr) {
		this.stockRepository = sr;
	}
	
	public Stock add(Stock stock) {
		Stock s = stockRepository.findByCode(stock.getCode());
		if(s != null)
			throw new IllegalArgumentException("Stock \"" + stock.getCode() +  "\" already exists.");
		
		return stockRepository.save(stock);
	}

}
