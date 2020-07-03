package com.thunderbulls;

import com.thunderbulls.stock.output.OutputBoundary;
import com.thunderbulls.stock.repository.Repository;

public interface UseCase<T extends Repository, U extends OutputBoundary> {

	public void setRepository(T repository);
	
	public void setOutput(U output);
}
