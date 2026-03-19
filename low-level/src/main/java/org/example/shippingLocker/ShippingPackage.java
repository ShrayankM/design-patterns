package org.example.shippingLocker;

public interface ShippingPackage {
	LockerSize getLockerSize();
	Account getAccount();
	PackageStatus getPackageStatus();
	void updatePackageStatus(PackageStatus packageStatus);
}
