package com.thunderbulls.adapter.data;

import java.io.Serializable;

public class StockDataEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String code;
	String company;
	
	public StockDataEntity(String code) {
		this.code = code;
	}
	
	public StockDataEntity(String code, String company) {
		this.code = code;
		this.company = company;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockDataEntity other = (StockDataEntity) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
}
