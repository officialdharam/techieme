public class LargestArea{
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		
		
		// trivial solution
		largetArea(A.length, A);

		// recursive solution
		System.out.println(largestAreaRecursive(A, 0, A.length - 1));
	}

	private static void largetArea(int N, int[] A) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int j = i;
			int num = A[j];
			int tempMax = 0;
			while (j < N && A[j] >= num) {
				tempMax += num;
				j++;
			}

			j = i - 1;
			while (j >= 0 && A[j] >= num) {
				tempMax += num;
				j--;
			}

			if (tempMax > max)
				max = tempMax;
		}

		System.out.println(max);
	}

	private static int largestAreaRecursive(int[] A, int l, int r) {
		if( r < l)
			return 0;
		if(r == l)
			return A[r];
		
		int min = l;
		for (int i = l; i < r; i++) {
			min = Math.min(A[i], A[min]) == A[i] ? i : min;
		}

		int left = largestAreaRecursive(A, l, min - 1);
		int right = largestAreaRecursive(A, min + 1, r);
		int total = A[min] * (r - l + 1);

		int max = Math.max(left, right);
		max = Math.max(max, total);
		return max;
	}
}
