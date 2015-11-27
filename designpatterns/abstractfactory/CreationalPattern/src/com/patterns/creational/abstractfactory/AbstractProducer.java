package com.patterns.creational.abstractfactory;

import com.patterns.creational.model.Furniture;

public abstract class AbstractProducer {

	public Furniture orderFurniture(String type) {
		Furniture furniture = createFurniture(type);
		furniture.makeFurniture();
		furniture.paint();
		furniture.polish();
		furniture.box();
		return furniture;
	}

	public abstract Furniture createFurniture(String type);
}
