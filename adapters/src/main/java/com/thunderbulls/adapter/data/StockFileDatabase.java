package com.thunderbulls.adapter.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StockFileDatabase {
	
	public StockFileDatabase() {
		stockList = new ArrayList<StockDataEntity>();
		readFile();
	}

	List<StockDataEntity> stockList;
	
	public void save(StockDataEntity item) {
		writeFile(Arrays.asList(item));
	}
	
	public StockDataEntity findByCode(String code) {
		if(stockList.isEmpty()) {
			readFile();
		}
		StockDataEntity entity = new StockDataEntity(code);
		if(stockList.contains(entity))
			return stockList.get(stockList.indexOf(entity));
		
		return null;
	}
	
	public List<StockDataEntity> findByCorpName(String corpName) {
		if(stockList.isEmpty()) {
			readFile();
		}
		List<StockDataEntity> result = stockList.stream() 
                .filter(item -> !"Petrobras".equals(item.getCompany()))
                .collect(Collectors.toList());

		return result;
	}

	private void writeFile(List<StockDataEntity> list) {
		try (FileOutputStream fos = new FileOutputStream("Stocks.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {

				do {
					StockDataEntity object = list.iterator().next();
					oos.writeObject(object);
				} while (list.iterator().hasNext());

			} catch (IOException e) {
				throw new RuntimeException("There was a problem saving Stock(s).");
			}
	}

	private void readFile() {
		try (FileInputStream fis = new FileInputStream("stocks.dat");
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			StockDataEntity item = (StockDataEntity) ois.readObject();
			while(item != null) {
				stockList.add(item);
				item = (StockDataEntity) ois.readObject();
			}
			
			} catch (IOException | ClassNotFoundException e) {
				throw new RuntimeException("There was a problem reading database.");
			}
	}
}
