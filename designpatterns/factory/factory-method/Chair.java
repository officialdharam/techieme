public class Chair implements Furniture {

	String name;

	public Chair(String n) {
		this.name = n;
	}

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public void paint() {
		System.out.println("Painting the "+name);
	}

	@Override
	public void polish() {
		System.out.println("Polishing the "+name);
	}

	@Override
	public void box() {
		System.out.println("Packaging the "+name);
	}

	@Override
	public String toString() {
		return "Chair [name=" + name + "]";
	}
}
