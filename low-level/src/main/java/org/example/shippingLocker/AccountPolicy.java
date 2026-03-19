package org.example.shippingLocker;

import lombok.Getter;

@Getter
public class AccountPolicy {
	private int freePeriodDays;
	private int maxExpiryDays;

	public AccountPolicy(int freePeriodDays, int maxExpiryDays) {
		this.freePeriodDays = freePeriodDays;
		this.maxExpiryDays = maxExpiryDays;
	}
}
