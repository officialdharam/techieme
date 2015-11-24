public class Table implements Furniture {
	
	String name="Computer Table";
	
	@Override
	public void paint() {
		System.out.println("Painting Table");
	}

	@Override
	public void polish() {
		System.out.println("Polishing Table");
	}

	@Override
	public void box() {
		System.out.println("Boxing Table");
	}

	@Override
	public String toString() {
		return "Table [name=" + name + "]";
	}
	
}
