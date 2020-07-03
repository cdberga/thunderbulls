package com.thunderbulls;

public abstract class UseCase<T extends Repository> {

	protected T repository;

	public UseCase() {
		super();
	}

	public void setRepository(T repo) {
		this.repository = repo;
	}
}
