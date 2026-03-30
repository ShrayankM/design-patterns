package org.example.commandPattern.diner;

public class BugerOrderCommand implements OrderCommand {
	private final Burger burger;

	public BugerOrderCommand(Burger burger) {
		this.burger = burger;
	}

	@Override
	public void prepareOrder() {
		this.burger.prepareBurger();
	}
}
