package org.example.questions.paymentWallet;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class Wallet {
	private String id;
	private User user;
	private BigDecimal balance;
	private TransactionManager transactionManager;

	public Wallet(User user, WalletManager walletManager) {
		this.id = UUID.randomUUID().toString();
		this.user = user;
		this.balance = BigDecimal.ZERO;
		this.transactionManager = new TransactionManager(walletManager);
	}

	public void addAmount(BigDecimal amount, String senderWalletId) {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			System.out.println("Cannot add negative value to balance");
			throw new IllegalArgumentException("Cannot add negative value to balance");
		}
		this.balance = this.balance.add(amount);
		this.transactionManager.logCreditTransaction(amount, senderWalletId, this.id);
	}

	public void withdrawAmount(BigDecimal amount, String receiverWalletId) {
		if (amount.compareTo(this.balance) > 0) {
			System.out.println("Insufficient balance in wallet");
			throw new IllegalArgumentException("Insufficient balance in wallet");
		}

		this.balance = this.balance.subtract(amount);
		this.transactionManager.logDebitTransaction(amount, this.id, receiverWalletId);
	}

	public void viewTransactionHistory() {
		System.out.println("Transaction history for wallet id = " + this.id + " for user = " + this.user.getName());
		this.transactionManager.viewTransactionHistory();
	}

	public void transferAmount(Wallet transferToWallet, BigDecimal amount) {
		boolean ack = this.transactionManager.transferAmountToWallet(this, transferToWallet, amount);
		if (ack) {
			System.out.println("Transfer to wallet id = " + transferToWallet.id + " was success");
		}
	}

	public void revertTransaction(Transaction transaction, BigDecimal refundAmount) {
		boolean ack = this.transactionManager.revertTransaction(transaction, refundAmount);
		if (ack) {
			System.out.println("Transcation reverted successfully");
		}
	}

	List<Transaction> getTransactionHistory() {
		return this.transactionManager.getTransactionHistory();
	}
}
