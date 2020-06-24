package com.thunderbulls.stock;

import java.util.List;

import com.thunderbulls.stock.repository.StockRepository;
import com.thunderbulls.stock.request.StockRequest;

public class FindStock implements StockRequest {

	private StockRepository stockRepository;

	public Stock findByCode(String code) {
		return stockRepository.findByCode(code);
	}

	public void setRepository(StockRepository sr) {
		this.stockRepository = sr;
	}

	public Stock findById(int id) {
		return stockRepository.findById(id);
	}

	public List<Stock> findByCorpName(String corpName) {
		return stockRepository.findByCorpName(corpName);
	}

}
