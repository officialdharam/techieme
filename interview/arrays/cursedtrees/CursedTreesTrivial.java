public class CursedTreesTrivial {
  public static void main(String[] args) {
		ArrayList<Integer> A = readFile();
		cursedTrees(A.toArray(new Integer[0]));
	}
	
	public static void cursedTrees(Integer[] A) {
		int size = 0;
		int counter = 0;
		do {
			size = A.size();
			int first = 0;
			Iterator<Integer> it = A.iterator();

			if (A.size() > 0)
				first = it.next();

			while (it.hasNext()) {
				int next = it.next();
				if (next > first)
					it.remove();
				first = next;
			}
			counter++;
		} while (A.size() != size);
		System.out.println(counter - 1);
		
	}
		private static ArrayList<Integer> readFile() {
		ArrayList<Integer> A = new ArrayList<Integer>();
		BufferedReader reader = null;
		try {
			FileReader fr = new FileReader("input2.txt");
			reader = new BufferedReader(fr);
			String line = null;
			String[] split = null;
			while ((line = reader.readLine()) != null) {
				split = line.split(" ");

			}
			for (int i = 0; i < split.length; i++) {
				A.add(Integer.parseInt(split[i]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
			}
		}
		return A;
	}
}
