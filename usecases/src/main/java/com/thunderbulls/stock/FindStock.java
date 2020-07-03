package com.thunderbulls.stock;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.UseCase;
import com.thunderbulls.stock.input.FindStockInput;
import com.thunderbulls.stock.output.FindStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public class FindStock extends UseCase<StockRepository> implements FindStockInput {

	FindStockOutput output;

	public FindStock() {
		super();
	}

	public ResponseModel<Stock> findByCode(String code) {
		Stock check = repository.findByCode(code);
		return output.createResponse(check, null);
	}

	public ResponseModel<List<Stock>> findByCorpName(String corpName) {
		List<Stock> list = repository.findByCorpName(corpName);
		return output.createResponse(list, null);
	}

	@Override
	public void setOutput(FindStockOutput output) {
		this.output = output;
	}

}
