package com.thunderbulls.stock;

public class Stock {

	private String code;
	private String companyName;

	public Stock(String code) {
		this.code = code;
	}

	public Stock(String code, String company) {
		this.code = code;
		this.companyName = company;
	}
}
