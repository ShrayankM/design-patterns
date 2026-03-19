package org.example.shippingLocker;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Locker {
	private String lockerId;
	private LockerSize lockerSize;
	private LockerStatus lockerStatus;
	private ShippingPackage assignedPackage;
	private String accessCode;
	private LocalDateTime assignedDate;

	public Locker(String lockerId, LockerSize lockerSize) {
		this.lockerId = lockerId;
		this.lockerSize = lockerSize;
		this.lockerStatus = LockerStatus.EMPTY;
	}

	public void assignPackageToLocker(ShippingPackage assignedPackage, String accessCode) {
		this.assignedPackage = assignedPackage;
		this.lockerStatus = LockerStatus.OCCUPIED;
		this.accessCode = accessCode;
		this.assignedDate = LocalDateTime.now();
	}

	public void removePackage() {
//		ShippingPackage returnPackage = this.assignedPackage;
		this.lockerStatus = LockerStatus.EMPTY;
		this.assignedPackage = null;
		this.assignedDate = null;
		this.accessCode = null;
	}

	public boolean isAvaiable() {
		return lockerStatus == LockerStatus.EMPTY;
	}

	public boolean verifyAccessCode(String accessCode) {
		return this.accessCode.equals(accessCode);
	}
}
