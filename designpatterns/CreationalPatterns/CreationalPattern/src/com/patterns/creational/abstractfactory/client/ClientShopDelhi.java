package com.patterns.creational.abstractfactory.client;

import com.patterns.creational.abstractfactory.AbstractProducer;
import com.patterns.creational.abstractfactory.FurnitureProducerDelhi;
import com.patterns.creational.abstractfactory.model.Furniture;

public class ClientShopDelhi {
	public static void main(String[] args) {
		AbstractProducer producer = new FurnitureProducerDelhi();
		Furniture chair = producer.orderFurniture("CHAIR");
		System.out.println("Got chair delivered :" + chair.toString());
	}
}
