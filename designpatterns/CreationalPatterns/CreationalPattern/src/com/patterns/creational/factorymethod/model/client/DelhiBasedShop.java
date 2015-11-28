package com.patterns.creational.factorymethod.model.client;

import com.patterns.creational.factorymethod.AbstractProducer;
import com.patterns.creational.factorymethod.FurnitureProducerDelhi;

public class DelhiBasedShop {
	public static void main(String[] args) {
		AbstractProducer delhiProducer = new FurnitureProducerDelhi();
		delhiProducer.orderFurniture("CHAIR");
		delhiProducer.orderFurniture("TABLE");
	}
}
