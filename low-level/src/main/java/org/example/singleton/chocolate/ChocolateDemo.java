package org.example.singleton.chocolate;

public class ChocolateDemo {
	public static void main(String [] args) {
		ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
		ChocolateBoiler chocolateBoiler1 =  ChocolateBoiler.getInstance();

		if (chocolateBoiler1 == chocolateBoiler) {
			System.out.println("Same");
		}
	}
}
