public class NQueen {

	private static int BOARD_SIZE = 5;

	public static void main(String[] args) {

		int[] G = new int[BOARD_SIZE];
		Arrays.fill(G, -1);
		placeQueen(G, 0);

	}

	private static void placeQueen(int[] G, int pos) {
		if (pos >= BOARD_SIZE) {
			printBoard(G);
			return;
		}

		for (int i = 0; i < BOARD_SIZE; i++) {
			G[pos] = i;
			if (isSafe(G, pos)) {
				placeQueen(G, pos + 1);
			} else {
				G[pos] = -1;
			}
		}
	}

	private static void printBoard(int[] g) {
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g.length; j++) {
				if (g[i] == j)
					System.out.print("Q ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean isSafe(int[] G, int pos) {
		for (int i = 0; i < pos; i++) {
			if (G[i] == G[pos]) {
				return false;
			}

			if (Math.abs(G[i] - G[pos]) == Math.abs(i - pos)) {
				return false;
			}
		}

		return true;
	}
}
