package com.iterator.pattern;

interface Bevarage {

	public String getDescription();

	public double getCost();
}

class DarkRoast implements Bevarage {

	
	public String getDescription() {

		return "Dark Roast Coffee";
	}

	
	public double getCost() {

		return .99;
	}

}

class CondimentDecorator implements Bevarage {
	protected Bevarage bevarage;

	public CondimentDecorator(Bevarage bevarage) {
		this.bevarage = bevarage;
	}

	
	public String getDescription() {

		return bevarage.getDescription();
	}

	
	public double getCost() {

		return bevarage.getCost();
	}
}

class Whip extends CondimentDecorator {

	Whip(Bevarage bevarage) {
		super(bevarage);
	}

	
	public String getDescription() {

		return bevarage.getDescription() + " ,Whip";
	}

	
	public double getCost() {

		return bevarage.getCost() + 0.10;
	}

}

class Mocha extends CondimentDecorator {
	Mocha(Bevarage bevarage) {
		super(bevarage);
	}

	
	public String getDescription() {

		return bevarage.getDescription() + " ,Mocha";
	}

	
	public double getCost() {

		return bevarage.getCost() + 0.56;
	}

}

public class StarbuzzCoffee {

	public static void main(String[] args) {

		Bevarage bevarage = new Mocha(new Mocha(new Whip(new DarkRoast())));
		System.out.println("the bevarage with addons: " + bevarage.getDescription());
		System.out.println("the Cost: $" + bevarage.getCost());
	}

}
