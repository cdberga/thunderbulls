package com.thunderbulls;

import java.util.List;

public class ResponseModel<T> {

	T object;
	List<String> errors;
	
	public ResponseModel(T object) {
		this.object = object;
	}
	
	public ResponseModel(T object, String error) {
		this.object = object;
		this.errors.add(error);
	}
	
	public ResponseModel() {
	}

	public List<String> getError() {
		return errors;
	}

	public T getObject() {
		return object;
	}
	
	public void addError(String error) {
		this.errors.add(error);
	}

	public void setObject(T object) {
		this.object = object;
	}

}
