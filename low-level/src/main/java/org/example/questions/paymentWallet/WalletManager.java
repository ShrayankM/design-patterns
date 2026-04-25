package org.example.questions.paymentWallet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WalletManager {
	private Map<String, Wallet> userWalletIdMap;
	private Map<String, Wallet> walletIdMap;

	public WalletManager() {
		this.userWalletIdMap = new HashMap<>();
		this.walletIdMap = new HashMap<>();
	}

	public Wallet createWalletForUser(User user) {
		String userId = user.getId();
		Wallet existingWallet = this.userWalletIdMap.get(userId);
		if (Objects.nonNull(existingWallet)) {
			System.out.println("user has wallet already linked, cannot add more");
			return existingWallet;
		}

		Wallet newWallet = new Wallet(user, this);
		userWalletIdMap.put(userId, newWallet);
		walletIdMap.put(newWallet.getId(), newWallet);
		return newWallet;
	}

	public Wallet getWalletById(String walletId) {
		return this.walletIdMap.getOrDefault(walletId, null);
	}
}
