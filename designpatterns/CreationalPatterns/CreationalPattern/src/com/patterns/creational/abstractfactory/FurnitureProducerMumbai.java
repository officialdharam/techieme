package com.patterns.creational.abstractfactory;

import com.patterns.creational.abstractfactory.model.Chair;
import com.patterns.creational.abstractfactory.model.Furniture;
import com.patterns.creational.abstractfactory.model.Table;

public class FurnitureProducerMumbai extends AbstractProducer {

	@Override
	public Furniture createFurniture(String type) {
		AbstractMaterialFactory factory = new MaterialFactoryForMumbai();
		Furniture furniture = null;
		if ("CHAIR".equals(type))
			furniture = new Chair("Mumbai Chair", factory);
		else if ("TABLE".equals(type))
			furniture = new Table("Mumbai Table", factory);
		return furniture;
	}
}
