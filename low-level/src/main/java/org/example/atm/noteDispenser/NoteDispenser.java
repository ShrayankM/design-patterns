package org.example.atm.noteDispenser;

import java.math.BigDecimal;

public interface NoteDispenser {
	boolean check(BigDecimal amount);
	void addNext(NoteDispenser noteDispenser);
	void dispense(BigDecimal amount);
}
