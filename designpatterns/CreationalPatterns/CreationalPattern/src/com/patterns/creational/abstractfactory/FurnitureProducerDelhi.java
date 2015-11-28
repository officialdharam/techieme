package com.patterns.creational.abstractfactory;

import com.patterns.creational.model.Chair;
import com.patterns.creational.model.Furniture;
import com.patterns.creational.model.Table;

public class FurnitureProducerDelhi extends AbstractProducer {

	@Override
	public Furniture createFurniture(String type) {
		AbstractMaterialFactory factory = new MaterialFactoryForDelhi();
		Furniture furniture = null;
		if ("CHAIR".equals(type))
			furniture = new Chair("Delhi Chair", factory);
		else if ("TABLE".equals(type))
			furniture = new Table("Delhi Table", factory);
		return furniture;
	}
}
