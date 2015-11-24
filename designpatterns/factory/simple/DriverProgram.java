public class DriverProgram {

	public static void main(String[] args) {
		FurnitureShop fs = new FurnitureShop();
		Furniture f1 = fs.orderFurniture("CHAIR");
		System.out.println("Got a new "+f1.toString());
		
		Furniture f2 = fs.orderFurniture("TABLE");
		System.out.println("Got a new "+f2.toString());
		
	}

}
