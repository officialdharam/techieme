public class DelhiBasedShop {
	public static void main(String[] args) {
		AbstractProducer delhiProducer = new FurnitureProducerDelhi();
		delhiProducer.orderFurniture("CHAIR");
		delhiProducer.orderFurniture("TABLE");
	}
}
