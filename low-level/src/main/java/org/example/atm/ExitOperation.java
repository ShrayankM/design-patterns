package org.example.atm;

public class ExitOperation implements AtmOperation {
	@Override
	public OperationType getOperationType() {
		return OperationType.EXIT;
	}

	@Override
	public boolean validateOperation() {
		return true;
	}

	@Override
	public void executeOperation() {

	}
}
