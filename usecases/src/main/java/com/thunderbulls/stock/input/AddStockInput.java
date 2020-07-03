package com.thunderbulls.stock.input;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.UseCase;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.output.AddStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public interface AddStockInput extends UseCase<StockRepository, AddStockOutput> {

	ResponseModel<Stock> add(Stock stock);
}
