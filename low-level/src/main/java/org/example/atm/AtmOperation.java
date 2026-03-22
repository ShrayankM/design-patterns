package org.example.atm;

import lombok.Getter;

@Getter
public class AtmOperation {
	private final OperationType operationType;
	private final BankAccount bankAccount;

	public AtmOperation(OperationType operationType, BankAccount bankAccount) {
		this.operationType = operationType;
		this.bankAccount = bankAccount;
	}
}
