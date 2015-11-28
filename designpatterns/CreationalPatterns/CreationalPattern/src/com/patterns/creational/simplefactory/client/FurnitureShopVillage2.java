package com.patterns.creational.simplefactory.client;

import com.patterns.creational.simplefactory.model.Furniture;

public class FurnitureShopVillage2 {
	public Furniture orderFurniture(String type) {
		FurnitureFactory factory = new FurnitureFactory();
		Furniture furniture = factory.createFurniture(type);
		furniture.paint();
		furniture.polish();
		furniture.box();
		return furniture;
	}
}
