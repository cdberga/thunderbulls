package com.thunderbulls.stock;

import java.util.List;

import com.thunderbulls.UseCase;
import com.thunderbulls.stock.repository.StockRepository;
import com.thunderbulls.stock.request.FindStockRequest;

public class FindStock extends UseCase<StockRepository> implements FindStockRequest {

	public FindStock() {
	}
	
	public FindStock(StockRepository repository) {
		super(repository);
	}
	
	public Stock findByCode(String code) {
		return repository.findByCode(code);
	}

	public List<Stock> findByCorpName(String corpName) {
		return repository.findByCorpName(corpName);
	}

}
