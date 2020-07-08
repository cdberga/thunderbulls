package com.thunderbulls.stock;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.output.AddStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public class AddStock implements AddStockInput {

	private Optional<AddStockOutput> output;
	private Optional<StockRepository> repository;

	public AddStock() {
	}

	public ResponseModel<Stock> add(Stock stock) {
		try {
			Stock s = repository.get().findByCode(stock.getCode());

			if (s != null) {
				return output.get().createResponse(stock, "Stock \"" + stock.getCode() + "\" already exists.");
			}

			return output.get().createResponse(repository.get().save(stock), null);
		} catch (NoSuchElementException e) {
			return new ResponseModel<Stock>(null,
					"There is no OutputBoundary or Repository set for Add Stock use case.");
		}
	}

	@Override
	public void setOutput(AddStockOutput output) {
		this.output = Optional.ofNullable(output);
	}

	@Override
	public void setRepository(StockRepository repository) {
		this.repository = Optional.ofNullable(repository);
	}
}
