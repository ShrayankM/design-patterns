package org.example.shippingLocker;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class LockerSite {
	private Map<LockerSize, Set<Locker>> lockerMap;
	private Map<String, Locker> lockerIdToLockerMap;

	public LockerSite(Map<LockerSize, Set<Locker>> lockerMap) {
		this.lockerMap = lockerMap;
		this.lockerIdToLockerMap = new HashMap<>();

		lockerMap.forEach((key, value) -> {
			for (Locker locker : value) {
				lockerIdToLockerMap.put(locker.getLockerId(), locker);
			}
		});
	}

	public Locker assignLockerToPackage(ShippingPackage shippingPackage, String accessCode) {
		Locker assignedLockerCopy = null;
		boolean lockerAssigned = false;
		for (LockerSize lockerSize : LockerSize.values()) {
			if (lockerSize.ordinal() >= shippingPackage.getLockerSize().ordinal()) {
				Set<Locker> lockers = lockerMap.get(lockerSize);

				for (Locker locker : lockers) {
					if (locker.isAvaiable()) {
						locker.assignPackageToLocker(shippingPackage, accessCode);
						lockerIdToLockerMap.put(locker.getLockerId(), locker);
						assignedLockerCopy = locker;
						lockerAssigned = true;
						break;
					}
				}

				if (lockerAssigned) break;
			}
		}

		if (!lockerAssigned) {
			System.out.println("No lockers are available");
		}
		return assignedLockerCopy;
	}

	public ShippingPackage retrivePackageFromLocker(String lockerId, String accessCode) {
		Locker locker = lockerIdToLockerMap.get(lockerId);

		if (Objects.nonNull(locker)) {
			if (locker.verifyAccessCode(accessCode)) {
				ShippingPackage shippingPackage = locker.getAssignedPackage();
				locker.removePackage();
				return shippingPackage;
			}
		}

		System.out.println("Locker id or access-code is incorrect, please check");
		return null;
	}

	public Locker getLockerById(String lockerId) {
		return lockerIdToLockerMap.get(lockerId);
	}
}
