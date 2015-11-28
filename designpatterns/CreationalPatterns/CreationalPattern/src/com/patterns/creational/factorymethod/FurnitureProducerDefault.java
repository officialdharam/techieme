package com.patterns.creational.factorymethod;

import com.patterns.creational.factorymethod.model.Chair;
import com.patterns.creational.factorymethod.model.Furniture;
import com.patterns.creational.factorymethod.model.Table;

public class FurnitureProducerDefault extends AbstractProducer {

	@Override
	public Furniture createFurniture(String type) {
		Furniture furniture = null;
		if ("CHAIR".equals(type))
			furniture = new Chair("Default Chair");
		else if ("TABLE".equals(type))
			furniture = new Table("Default Table");
		return furniture;
	}
}
