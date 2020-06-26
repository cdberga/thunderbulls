package com.thunderbulls.stock;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.UseCase;
import com.thunderbulls.stock.repository.StockRepository;
import com.thunderbulls.stock.request.FindStockInput;

public class FindStock extends UseCase<StockRepository> implements FindStockInput {

	public FindStock() {
	}
	
	public FindStock(StockRepository repository) {
		super(repository);
	}
	
	public ResponseModel<Stock> findByCode(String code) {
		ResponseModel<Stock> response = null;
		try {
			Stock check = repository.findByCode(code);
			response = new ResponseModel<Stock>(check, null);
		} catch (Exception e) {
			response.setError(e);
		}
		return response;
	}

	public ResponseModel<List<Stock>> findByCorpName(String corpName) {
		ResponseModel<List<Stock>> response = null;
		try {
			List<Stock> list = repository.findByCorpName(corpName);
			response = new ResponseModel<List<Stock>>(list, null);
		} catch (Exception e) {
			response.setError(e);
		}
		return response;
	}

}
