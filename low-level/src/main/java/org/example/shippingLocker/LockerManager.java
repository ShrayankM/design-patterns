package org.example.shippingLocker;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class LockerManager {
	private LockerSite lockerSite;
	private NotificationService notificationService;
	private Map<String, Account> accountMap;

	public LockerManager(NotificationService notificationService, Map<String, Account> accountMap,
			LockerSite lockerSite) {
		this.notificationService = notificationService;
		this.accountMap = accountMap;
		this.lockerSite = lockerSite;
	}

	public Locker assignPackage(ShippingPackage shippingPackage) {
//		int generateRandomAccessCode = new Random().nextInt(0, 1000);
		Locker assignedLocker = this.lockerSite.assignLockerToPackage(shippingPackage,
				String.valueOf(10069));

//		String message = "Locker-id = [" + assignedLocker.getLockerId() + "], Access-code = {"
//				+ generateRandomAccessCode + "}";

		String message = "Locker-id = [" + assignedLocker.getLockerId() + "], Access-code = {"
				+ 10069 + "}";

		notificationService.sendNotification(message, shippingPackage.getAccount());
		return assignedLocker;
	}

	public ShippingPackage retrivePackage(String lockerId, String accessCode) {
		Locker locker = this.lockerSite.getLockerById(lockerId);
		BigDecimal lockerCharges = calculateLockerCharger(locker);
		if (Objects.isNull(lockerCharges)) return null;

		ShippingPackage shippingPackage = this.lockerSite.retrivePackageFromLocker(lockerId, accessCode);
		if (Objects.nonNull(shippingPackage)) return shippingPackage;
		return null;
	}

	private BigDecimal calculateLockerCharger(Locker locker) {
		Account userAccount = locker.getAssignedPackage().getAccount();;
		AccountPolicy accountPolicy = userAccount.getAccountPolicy();
		long totalDaysUsed = Duration.between(locker.getAssignedDate(), LocalDateTime.now()).toSeconds();

		totalDaysUsed = totalDaysUsed - accountPolicy.getFreePeriodDays();
		if (totalDaysUsed > accountPolicy.getMaxExpiryDays()) {
			System.out.println("Package has exceeded maximum policy days, cannot retrieve");
			return null;
		}

		totalDaysUsed = totalDaysUsed - accountPolicy.getFreePeriodDays();
		BigDecimal totalCharge = new BigDecimal("0.0");
		if (totalDaysUsed > 0) {
			totalCharge = userAccount.getChargePerDay().multiply(BigDecimal.valueOf(totalDaysUsed));
		}

		System.out.println("Total charge for package = " + totalCharge);
		return totalCharge;
	}
}
