public class CursedTreesEfficient {
  public static void main(String[] args) {
		ArrayList<Integer> A = readFile();
		cursedTrees(A.toArray(new Integer[0]));
	}
	
	public static void cursedTrees(Integer[] A) {
		LinkedList<Node> tempList = new LinkedList<Node>();
		int years = 0;
		int first = A[0];
		// add the first one in LL and make life as -1
		tempList.add(new Node(-1, first));
		for (int i = 1; i < A.length; ++i) {
			int currentTreeHeight = A[i];
			Iterator<Node> it = tempList.iterator();
			// we assume that every plant will live for a day.
			int yearsToSurvive = 1;

			while (it.hasNext()) {
				Node prev = it.next();
				// if the new plant has a wont die today, we remove the first
				// plant and assign a new life to the new life
				if (currentTreeHeight <= prev.height) {
					it.remove();
					yearsToSurvive = prev.life == -1 ? -1 : (prev.life + 1);
				} else {
					break;
				}
			}
			// check for smaller nodes
			while (!tempList.isEmpty() && yearsToSurvive == tempList.get(0).life) {
				tempList.remove(0);
			}
			years = Math.max(years, yearsToSurvive);
			tempList.add(0, new Node(yearsToSurvive, currentTreeHeight));
			
		}
		System.out.println(years);
		
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
