package com.patterns.creational.factorymethod;

import com.patterns.creational.factorymethod.model.Chair;
import com.patterns.creational.factorymethod.model.Furniture;
import com.patterns.creational.factorymethod.model.Table;

public class FurnitureProducerDelhi extends AbstractProducer {

	@Override
	public Furniture createFurniture(String type) {
		Furniture furniture = null;
		if ("CHAIR".equals(type))
			furniture = new Chair("Delhi Style Chair");
		else if ("TABLE".equals(type))
			furniture = new Table("Delhi Style Table");
		return furniture;
	}

}
