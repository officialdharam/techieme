package com.patterns.creational.abstractfactory.model;

import com.patterns.creational.abstractfactory.AbstractMaterialFactory;

public class Table extends Furniture {

	AbstractMaterialFactory materialFactory;

	public Table(String n, AbstractMaterialFactory materialFactory) {
		this.materialFactory = materialFactory;
		this.name = n;
	}

	@Override
	public void paint() {
		System.out.println("Painting the " + name);
	}

	@Override
	public void polish() {
		System.out.println("Polishing the " + name);
	}

	@Override
	public void box() {
		System.out.println("Packaging the " + name);
	}

	@Override
	public void makeFurniture() {
		glue = materialFactory.getGlue();
		nail = materialFactory.getNail();
		wood = materialFactory.getWood();
	}
	
	@Override
	public String toString() {
		return "Furniture [name=" + name + ", wood=" + wood + ", nail=" + nail + ", glue=" + glue + "]";
	}
}
