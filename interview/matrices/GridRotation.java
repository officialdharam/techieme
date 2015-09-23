public class GridRotation {
	public static void main(String[] args) {
		int M = 4, N = 7, rotate = 20;
		long c[][] = new long[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},{21,22,23,24},{25,26,27,28}};
		int min = Math.min(M, N);
		int C = min/2;

		for (int i = 0; i < C; i++) {
			String walk = walk(c, i);
			if (walk.length() > 0) {
				String[] split = walk.split(" ");
				long[] L = new long[split.length];
				for (int k = 0; k < split.length; k++) {
					L[k] = Long.parseLong(split[k]);
				}

				rotate(c, i, rotate, L);
			}
		}

		print(c);
	}

	static void rotate(long[][] c, int idx, int r, long[] C) {
		if (r == 0 || r % C.length == 0)
			return;

		r = r % C.length;
		long[] d = new long[C.length];
		for (int i = 0; i < C.length; i++) {
			d[i] = C[(i + r) % C.length];
		}

		int i = idx, j = idx;
		int count = 0;
		while (j < c[i].length - idx) {
			c[i][j] = d[count++];
			j++;
		}
		j--;
		i++;
		while (i < c.length - idx - 1) {
			c[i][j] = d[count++];
			i++;
		}
		while (j >= idx) {
			c[i][j] = d[count++];
			j--;
		}
		j++;
		i--;
		while (i > idx) {
			c[i][j] = d[count++];
			i--;
		}

	}

	static String walk(long[][] c, int idx) {
		int i = idx, j = idx;
		StringBuilder sb = new StringBuilder();
		while (j < c[i].length - idx) {
			sb.append(c[i][j] + " ");
			j++;
		}
		j--;
		i++;
		while (i < c.length - idx - 1) {
			sb.append(c[i][j] + " ");
			i++;
		}
		while (j >= idx) {
			sb.append(c[i][j] + " ");
			j--;
		}
		j++;
		i--;
		while (i > idx) {
			sb.append(c[i][j] + " ");
			i--;
		}
		return sb.toString();
	}

	static void print(long[][] c) {
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				if (j > 0)
					System.out.print(" ");
				System.out.print(c[i][j]);
			}
			System.out.println();
		}
	}
}
