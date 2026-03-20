package org.example.factoryPattern.abstractFactory;

import org.example.factoryPattern.factoryMethod.Pizza;

import java.util.ArrayList;
import java.util.Arrays;

public class NyCheesePizza extends Pizza {
	public NyCheesePizza() {
		super("NyCheese Pizza", "Red-sauce", "Thin",
				new ArrayList<>(Arrays.asList("Tomato", "Onion")));
	}
}
