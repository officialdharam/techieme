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
