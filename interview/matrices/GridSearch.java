public class GridSearch {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);	
	
	int R = sc.nextInt();
	int C = sc.nextInt();
	List<String> G = new ArrayList<String>();
	for (int i = 0; i < R; i++) {
		G.add(sc.next());
	}

	int r = sc.nextInt();
	int c = sc.nextInt();
	List<String> P = new ArrayList<String>();
	for (int i = 0; i < r; i++) {
		P.add(sc.next());
	}

	String res = "NO";
	String p = P.get(0);
	StringBuilder completePattern = new StringBuilder();
	for (String pt : P)
		completePattern.append(pt);

	boolean found = false;
	for (int j = 0; j <= R - r; j++) {
		List<Integer> indices = new ArrayList<Integer>();
		String g = G.get(j);
		int index = 0;
		while (index <= C - c) {
			index = g.indexOf(p, index);
			if (index == -1)
				break;
			indices.add(index++);
		}
		if (indices.size() > 0) {
			StringBuilder completeGrid = new StringBuilder();
			for (Integer ind : indices) {
				for (int i = j; i < j + r; i++) {
					completeGrid.append(G.get(i).substring(ind, ind + c));
				}
				if (completeGrid.toString().equals(completePattern.toString())) {
					res = "YES";
					found = true;
					break;
				}
			}
			if (found)
				break;
		}
	}
	System.out.println(res);
}
}
