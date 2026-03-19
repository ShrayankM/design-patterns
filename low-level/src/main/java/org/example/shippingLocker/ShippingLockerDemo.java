package org.example.shippingLocker;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShippingLockerDemo {
	public static void main(String [] args) {

		Account a = new Account("a", new AccountPolicy(2, 100),
				new BigDecimal("5.0"));

		Map<String, Account> accountMap = new HashMap<>();
		accountMap.put(a.getId(), a);

		Map<LockerSize, Set<Locker>> lockerSizeSetMap = new HashMap<>();

		Locker s1 = new Locker("s1", LockerSize.SMALL);
		Locker s2 = new Locker("s1", LockerSize.SMALL);
		lockerSizeSetMap.put(LockerSize.SMALL, new HashSet<>(List.of(s1, s2)));

		LockerSite lockerSite = new LockerSite(lockerSizeSetMap);

		NotificationService smsService = new SmsNotificationService();
		LockerManager lockerManager = new LockerManager(smsService, accountMap, lockerSite);

		lockerManager.assignPackage(new BasicShippingPackage(LockerSize.SMALL, a));

		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		lockerManager.retrivePackage(s1.getLockerId(), String.valueOf(10069));
	}
}
