public class FurnitureFactory {
	public Furniture createFurniture(String type) {
		Furniture furniture = null;
		if ("CHAIR".equals(type))
			furniture = new Chair();
		else if ("TABLE".equals(type))
			furniture = new Table();
		else if ("BED".equals(type))
			furniture = new Bed();
		
		return furniture;
	}
}
