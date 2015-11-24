public class FurnitureShopVillage2 {
	public Furniture orderFurniture(String type) {
		Furniture furniture = null;
		if ("CHAIR".equals(type))
			furniture = new Chair();
		else if ("TABLE".equals(type))
			furniture = new Table();

		furniture.paint();
		furniture.polish();
		furniture.box();
		return furniture;
	}
}
