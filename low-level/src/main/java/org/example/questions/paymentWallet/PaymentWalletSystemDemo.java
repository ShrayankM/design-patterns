package org.example.questions.paymentWallet;

import java.math.BigDecimal;

public class PaymentWalletSystemDemo {
	public static void main(String [] args) {
		User a = new User("a1", "A");
		User b = new User("b1", "B");

		WalletManager walletManager = new WalletManager();
		Wallet userAWallet = walletManager.createWalletForUser(a);
		Wallet userBWallet = walletManager.createWalletForUser(b);

		userAWallet.addAmount(new BigDecimal("12.39"), "self");
		userBWallet.addAmount(new BigDecimal("50.99"), "self");

		userBWallet.transferAmount(userAWallet, BigDecimal.valueOf(12.39));

		userAWallet.viewTransactionHistory();
		userBWallet.viewTransactionHistory();

		Transaction latestTransaction = userAWallet.getTransactionHistory().get(1);
		userAWallet.revertTransaction(latestTransaction, BigDecimal.valueOf(10.00));

		userAWallet.viewTransactionHistory();
		userBWallet.viewTransactionHistory();
	}
}
