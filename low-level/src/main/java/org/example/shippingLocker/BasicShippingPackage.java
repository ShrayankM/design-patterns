package org.example.shippingLocker;

public class BasicShippingPackage implements ShippingPackage {
	private LockerSize lockerSize;
	private PackageStatus packageStatus;
	private Account account;

	public BasicShippingPackage(LockerSize lockerSize, Account account) {
		this.lockerSize = lockerSize;
		this.packageStatus = PackageStatus.CREATED;
		this.account = account;
	}

	@Override
	public LockerSize getLockerSize() {
		return this.lockerSize;
	}

	@Override
	public Account getAccount() {
		return this.account;
	}

	@Override
	public PackageStatus getPackageStatus() {
		return this.packageStatus;
	}

	@Override
	public void updatePackageStatus(PackageStatus packageStatus) {
		this.packageStatus = packageStatus;
	}
}
