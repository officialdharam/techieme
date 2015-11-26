public class JayShop {
	public static void main(String[] args) {
		AbstractProducer defaultProducer = new FurnitureProducerDefault();
		defaultProducer.orderFurniture("CHAIR");
		defaultProducer.orderFurniture("TABLE");
	}
}
