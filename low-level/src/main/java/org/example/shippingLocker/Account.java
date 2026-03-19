package org.example.shippingLocker;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Account {
	private String id;
	private AccountPolicy accountPolicy;
	private BigDecimal chargePerDay;

	public Account(String id, AccountPolicy accountPolicy, BigDecimal chargePerDay) {
		this.id = id;
		this.accountPolicy = accountPolicy;
		this.chargePerDay = chargePerDay;
	}
}
