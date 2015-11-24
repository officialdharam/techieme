public class DriverProgram {

	public static void main(String[] args) {
		FurnitureShop fs = new FurnitureShop();
		Furniture f1 = fs.orderFurniture("CHAIR");
		System.out.println("Got a new "+f1.toString());
		
		FurnitureShopVillage1 fsv1 = new FurnitureShopVillage1();
		Furniture f2 = fsv1.orderFurniture("TABLE");
		System.out.println("Got a new "+f2.toString());
		
		FurnitureShopVillage2 fsv2 = new FurnitureShopVillage2();
		Furniture f3 = fsv2.orderFurniture("BED");
		System.out.println("Got a new "+f3.toString());
		
	}

}
