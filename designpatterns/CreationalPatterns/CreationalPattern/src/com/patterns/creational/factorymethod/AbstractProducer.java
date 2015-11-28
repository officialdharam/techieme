package com.patterns.creational.factorymethod;

import com.patterns.creational.factorymethod.model.Furniture;


public abstract class AbstractProducer {

	public Furniture orderFurniture(String type) {
		Furniture furniture = createFurniture(type);
		furniture.paint();
		furniture.polish();
		furniture.box();
		return furniture;
	}

	public abstract Furniture createFurniture(String type);
}
