package com.patterns.creational.simplefactory.model;

public class Chair implements Furniture {

	String name="New Fabric Chair";
	
	@Override
	public String toString() {
		return "Chair [name=" + name + "]";
	}

	@Override
	public void paint() {
		System.out.println("Painting Chair");
	}

	@Override
	public void polish() {
		System.out.println("Polishing Chair");
	}

	@Override
	public void box() {
		System.out.println("Boxing Chair");
	}

}
