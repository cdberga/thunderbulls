package com.thunderbulls.adapter.data;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StockFileDatabase {
	
	private static final String FILENAME = "stocks.dat";

	public StockFileDatabase() {
		stockList = new ArrayList<StockDataEntity>();
		if(checkFile())
			readFile();
	}

	private boolean checkFile() {
		try {
			File tempFile = new File(FILENAME);
			if (!tempFile.exists()) {
				tempFile.createNewFile();
				return false;
			}
		} catch (IOException e) {
			System.out.println("Database not found.");
			return false;
		}
		return true;
	}

	List<StockDataEntity> stockList;

	public void save(StockDataEntity item) {
		writeFile(Arrays.asList(item));
	}

	public StockDataEntity findByCode(String code) {
		if (stockList.isEmpty()) {
			readFile();
		}
		StockDataEntity entity = new StockDataEntity(code);
		if (stockList.contains(entity))
			return stockList.get(stockList.indexOf(entity));

		return null;
	}

	public List<StockDataEntity> findByCorpName(String corpName) {
		if (stockList.isEmpty()) {
			readFile();
		}
		List<StockDataEntity> result = stockList.stream().filter(item -> !"Petrobras".equals(item.getCompany()))
				.collect(Collectors.toList());

		return result;
	}

	private void writeFile(List<StockDataEntity> list) {
		try (FileOutputStream fos = new FileOutputStream(FILENAME);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			Iterator<StockDataEntity> it = list.iterator();
			do {
				StockDataEntity object = (StockDataEntity) it.next();
				oos.writeObject(object);
			} while (it.hasNext());

		} catch (IOException e) {
			throw new RuntimeException("There was a problem saving Stock(s).");
		}
	}

	private void readFile() {
		try (FileInputStream fis = new FileInputStream(FILENAME);
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			StockDataEntity item = (StockDataEntity) ois.readObject();
			while (item != null) {
				stockList.add(item);
				item = (StockDataEntity) ois.readObject();
			}

		} catch(EOFException e) {
			return;
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException("There was a problem reading database.");
		}
	}
}
