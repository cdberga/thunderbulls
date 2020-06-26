package com.thunderbulls;

public class ResponseModel<T> {

	T object;
	Throwable error;
	
	public ResponseModel(T object, Throwable error) {
		this.object = object;
		this.error = error;
	}
	
	public Throwable getError() {
		return error;
	}

	public T getObject() {
		return object;
	}
	
	public void setError(Throwable error) {
		this.error = error;
	}

	public void setObject(T object) {
		this.object = object;
	}

}
