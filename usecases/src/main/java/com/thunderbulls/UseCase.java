package com.thunderbulls;

public abstract class UseCase<T extends Repository, U> {

	protected T repository;

	public UseCase() {
		super();
	}

	public UseCase(T repository) {
		super();
		setRepository(repository);
	}

	public void setRepository(T repo) {
		this.repository = repo;
	}

	public abstract ResponseModel<U> createResponse(U object, String errorMessage);
}
