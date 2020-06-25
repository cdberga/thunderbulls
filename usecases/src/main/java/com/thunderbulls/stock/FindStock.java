package com.thunderbulls.stock;

import java.util.List;

import com.thunderbulls.stock.repository.StockRepository;
import com.thunderbulls.stock.request.FindStockRequest;

public class FindStock implements FindStockRequest {

	private StockRepository stockRepository;

	public void setRepository(StockRepository sr) {
		this.stockRepository = sr;
	}

	public Stock findByCode(String code) {
		return stockRepository.findByCode(code);
	}

	public List<Stock> findByCorpName(String corpName) {
		return stockRepository.findByCorpName(corpName);
	}

}
