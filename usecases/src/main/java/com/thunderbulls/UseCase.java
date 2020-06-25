package com.thunderbulls;

public abstract class UseCase<T extends Repository> {

	protected T repository;

	public UseCase() {
		
	}
	
	public UseCase(T repository) {
		super();
		setRepository(repository);
	}

	public void setRepository(T repo) {
		this.repository = repo;
	}

}