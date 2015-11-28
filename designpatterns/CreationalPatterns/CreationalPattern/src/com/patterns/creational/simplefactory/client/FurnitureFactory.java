package com.patterns.creational.simplefactory.client;

import com.patterns.creational.simplefactory.model.Bed;
import com.patterns.creational.simplefactory.model.Chair;
import com.patterns.creational.simplefactory.model.Furniture;
import com.patterns.creational.simplefactory.model.Table;

public class FurnitureFactory {
	public Furniture createFurniture(String type) {
		Furniture furniture = null;
		if ("CHAIR".equals(type))
			furniture = new Chair();
		else if ("TABLE".equals(type))
			furniture = new Table();
		else if ("BED".equals(type))
			furniture = new Bed();
		
		return furniture;
	}
}
