package org.example.factoryPattern.abstractFactory;

import org.example.factoryPattern.factoryMethod.Pizza;

import java.util.ArrayList;
import java.util.Arrays;

public class IndianPaneerPizza extends Pizza {
	public IndianPaneerPizza() {
		super("Paneer pizza", "Tomato-sauce", "Thick",
				new ArrayList<>(Arrays.asList("Paneer", "Onion", "Capsicum")));
	}
}
