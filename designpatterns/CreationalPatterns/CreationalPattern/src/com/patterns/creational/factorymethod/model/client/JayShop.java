package com.patterns.creational.factorymethod.model.client;

import com.patterns.creational.factorymethod.AbstractProducer;
import com.patterns.creational.factorymethod.FurnitureProducerDefault;

public class JayShop {
	public static void main(String[] args) {
		AbstractProducer defaultProducer = new FurnitureProducerDefault();
		defaultProducer.orderFurniture("CHAIR");
		defaultProducer.orderFurniture("TABLE");
	}
}
