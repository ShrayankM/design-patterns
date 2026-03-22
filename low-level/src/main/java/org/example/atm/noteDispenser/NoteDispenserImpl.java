package org.example.atm.noteDispenser;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NoteDispenserImpl implements NoteDispenser {
	private final BigDecimal denomination;
	private int denominationCount;
	private NoteDispenser nextNoteDispenser;

	public NoteDispenserImpl(BigDecimal denomination, int denominationCount) {
		this.denomination = denomination;
		this.denominationCount = denominationCount;
		this.nextNoteDispenser = null;
	}

	@Override
	public boolean check(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			return true;
		}

		int notesRequired = amount.divide(denomination, RoundingMode.HALF_UP).intValue();
		int notesToDispense = Math.min(notesRequired, denominationCount);

		BigDecimal dispensedAmount = denomination.multiply(BigDecimal.valueOf(notesToDispense));
		BigDecimal remainingAmount = amount.subtract(dispensedAmount);

		if (remainingAmount.compareTo(BigDecimal.ZERO) > 0 && nextNoteDispenser != null) {
			return nextNoteDispenser.check(remainingAmount);
		}
		return remainingAmount.compareTo(BigDecimal.ZERO) <= 0;
	}

	@Override
	public void dispense(BigDecimal amount) {
		int notesRequired = amount.divide(denomination, RoundingMode.HALF_UP).intValue();
		int notesToDispense = Math.min(notesRequired, denominationCount);

		denominationCount -= notesToDispense;

		BigDecimal dispensedAmount = denomination.multiply(BigDecimal.valueOf(notesToDispense));
		BigDecimal remainingAmount = amount.subtract(dispensedAmount);

		if (remainingAmount.compareTo(BigDecimal.ZERO) > 0 && nextNoteDispenser != null) {
			nextNoteDispenser.dispense(remainingAmount);
		}
	}

	@Override
	public void addNext(NoteDispenser noteDispenser) {
		this.nextNoteDispenser = noteDispenser;
	}
}
