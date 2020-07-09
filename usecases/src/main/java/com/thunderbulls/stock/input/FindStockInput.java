package com.thunderbulls.stock.input;

import java.util.List;

import com.thunderbulls.ResponseModel;
import com.thunderbulls.UseCase;
import com.thunderbulls.stock.Stock;
import com.thunderbulls.stock.output.FindStockOutput;
import com.thunderbulls.stock.repository.StockRepository;

public interface FindStockInput extends UseCase<StockRepository, FindStockOutput>{

	ResponseModel<Stock> findByCode(String code);
	
	ResponseModel<List<Stock>> findByCorpName(String corpName);

	ResponseModel<List<Stock>> findAll();
}
