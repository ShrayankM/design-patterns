package org.example.questions.paymentWallet;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Transaction {
	private String id;
	private LocalDateTime timestamp;
	private TransactionType transactionType;
	private BigDecimal amount;
	private String senderWalletId;
	private String receiverWalletId;
	private TransactionStatus transactionStatus;

	public Transaction(TransactionType transactionType, BigDecimal amount,
			String senderWalletId, String receiverWalletId) {
		this.id = UUID.randomUUID().toString();
		this.timestamp = LocalDateTime.now();
		this.transactionType = transactionType;
		this.amount = amount;
		this.senderWalletId = senderWalletId;
		this.receiverWalletId = receiverWalletId;
		this.transactionStatus = TransactionStatus.PENDING;
	}

	@Override
	public String toString() {
		return "Id [" + this.id + "#-" + this.timestamp + "] " + "Type = {" + this.transactionType + "},"
				+ " (" + this.amount + ")" + " \n Sender-Receiver [" + senderWalletId + " || " + receiverWalletId + "]";
	}
}
