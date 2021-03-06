package com.thunderbulls.adapter.view;

public class StockViewModel {

	private String code;
	private String company;

	public StockViewModel(String code, String companyName) {
		this.code = code;
		this.company = companyName;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCompany(String companyName) {
		this.company = companyName;
	}

	public String getCode() {
		return code;
	}

	public String getCompany() {
		return company;
	}

}
