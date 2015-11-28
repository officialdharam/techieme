package com.patterns.creational.abstractfactory.model;

public abstract class Furniture {

	public abstract void paint();

	public abstract void polish();

	public abstract void box();

	public abstract void makeFurniture();

	String name;
	Wood wood;
	Nail nail;
	Glue glue;

}
