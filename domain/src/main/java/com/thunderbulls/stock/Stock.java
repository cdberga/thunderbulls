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

	public String getCode() {
		return this.code;
	}

	public String getCompanyName() {
		return companyName;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public boolean equals(Object obj) {
		Stock newStock = (Stock)obj;
		return this.getCode().equals(newStock.getCode());
	}

	@Override
	public int hashCode() {
		return this.getCode().hashCode();
	}
}
