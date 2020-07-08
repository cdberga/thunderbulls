package com.thunderbulls.stock;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.input.FindStockInput;
import com.thunderbulls.stock.output.FindStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public class FindStock implements FindStockInput {

	private Optional<FindStockOutput> output;
	private Optional<StockRepository> repository;

	public FindStock() {
	}

	public ResponseModel<Stock> findByCode(String code) {
		try {
			Stock check = repository.get().findByCode(code);
			return output.get().createResponse(check, null);
		} catch (NoSuchElementException e) {
			return new ResponseModel<Stock>(null, "There is no OutputBoundary or Repository set for Find Stock use case.");
		}
	}

	public ResponseModel<List<Stock>> findByCorpName(String corpName) {
		try {
			List<Stock> list = repository.get().findByCorpName(corpName);
			return output.get().createListResponse(list, null);
		} catch (NoSuchElementException e) {
			return new ResponseModel<List<Stock>>(null, "There is no OutputBoundary or Repository set for Find Stock use case.");
		}
	}

	@Override
	public void setOutput(FindStockOutput output) {
		this.output = Optional.ofNullable(output);
	}

	@Override
	public void setRepository(StockRepository repository) {
		this.repository = Optional.ofNullable(repository);
	}

}
