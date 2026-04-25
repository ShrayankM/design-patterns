package org.example.questions.paymentWallet;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
public class TransactionManager {
	private List<Transaction> transactionHistory;
	private WalletManager walletManager;

	public TransactionManager(WalletManager walletManager) {
		this.transactionHistory = new CopyOnWriteArrayList<>();
		this.walletManager = walletManager;
	}

	void logCreditTransaction(BigDecimal amount, String senderWalletId, String receiverWalletId) {
		Transaction t = new Transaction(TransactionType.CREDIT, amount, senderWalletId, receiverWalletId);
		t.setTransactionStatus(TransactionStatus.COMPLETED);
		this.transactionHistory.add(t);
	}

	void logDebitTransaction(BigDecimal amount, String senderWalletId, String receiverWalletId) {
		Transaction t = new Transaction(TransactionType.DEBIT, amount, senderWalletId, receiverWalletId);
		t.setTransactionStatus(TransactionStatus.COMPLETED);
		this.transactionHistory.add(t);
	}

//	void logRefundTransaction(BigDecimal amount) {
//		Transaction t = new Transaction(TransactionType.REFUND, amount);
//		this.transactionHistory.add(t);
//	}

	void viewTransactionHistory() {
		for (Transaction t : transactionHistory) {
			System.out.println(t);
		}
	}

	List<Transaction> getTransactionHistory() {
		return this.transactionHistory;
	}

	boolean transferAmountToWallet(Wallet from, Wallet to, BigDecimal amount) {

		// Consistent lock ordering by wallet ID to prevent deadlock
		Wallet first = from.getId().compareTo(to.getId()) < 0 ? from : to;
		Wallet second = first == from ? to : from;
		synchronized (first) {
			synchronized (second) {
				// debit + credit here
				try {
					from.withdrawAmount(amount, to.getId());
				} catch (Exception e) {
					System.out.println("Error occurred while trying to deduct amount from sender");
					throw e;
				}

				try {
					to.addAmount(amount, from.getId());
				} catch (Exception e) {
					System.out.println("Error occurred while trying to add amount from receiver");
					from.addAmount(amount, to.getId());
					throw e;
				}
			}
		}
		return true;
	}

	boolean revertTransaction(Transaction transaction, BigDecimal refundAmount) {
		if (transaction.getTransactionStatus() == TransactionStatus.REFUNDED) {
			throw new IllegalStateException("Transaction already refunded");
		}
		BigDecimal amount = transaction.getAmount();

		if (amount.compareTo(refundAmount) < 0) {
			throw new IllegalArgumentException("Refund amount cannot exceed original transaction amount of " + amount);
		}

		Wallet senderWallet = walletManager.getWalletById(transaction.getSenderWalletId());
		Wallet receiverWallet = walletManager.getWalletById(transaction.getReceiverWalletId());

		try {
			transferAmountToWallet(receiverWallet, senderWallet, refundAmount);
		} catch (Exception e) {
			System.out.println("Transaction could not be reverted, please try later");
			return false;
		}
		// ... after successful revert:
		transaction.setTransactionStatus(TransactionStatus.REFUNDED);
		return true;
	}

}
