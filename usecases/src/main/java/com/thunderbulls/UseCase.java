package com.thunderbulls;

public abstract class UseCase<T extends Repository, U> {

	protected T repository;

	public UseCase() {
		super();
	}

	public void setRepository(T repo) {
		this.repository = repo;
	}

	public abstract ResponseModel<U> createResponse(U object, String errorMessage);
}
