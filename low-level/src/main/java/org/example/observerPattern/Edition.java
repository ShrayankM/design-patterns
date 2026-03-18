package org.example.observerPattern;

import java.time.LocalDateTime;

public class Edition {
	private LocalDateTime editionDate;
	private String editionName;
	private EditionType editionType;

	public Edition(String editionName, EditionType editionType) {
		this.editionName = editionName;
		this.editionType = editionType;
		this.editionDate = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return this.editionName + ", " + this.editionType + "[" + this.editionDate + "]";
	}
}
