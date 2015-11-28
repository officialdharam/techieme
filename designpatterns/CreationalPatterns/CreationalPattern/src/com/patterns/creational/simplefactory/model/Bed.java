package com.patterns.creational.simplefactory.model;

public class Bed implements Furniture {

	String name="New Queen Size Bed";
	
	@Override
	public String toString() {
		return "Bed [name=" + name + "]";
	}

	@Override
	public void paint() {
		System.out.println("Painting Bed");
	}

	@Override
	public void polish() {
		System.out.println("Polishing Bed");
	}

	@Override
	public void box() {
		System.out.println("Boxing Bed");
	}

}
