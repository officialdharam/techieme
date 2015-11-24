public class FurnitureShopVillage1 {

	public Furniture orderFurniture(String type) {
		FurnitureFactory factory = new FurnitureFactory();
		Furniture furniture = factory.createFurniture(type);
		furniture.paint();
		furniture.polish();
		furniture.box();
		return furniture;
	}
}
