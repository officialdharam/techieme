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
