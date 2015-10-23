public class MedianFinder {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		int z = 0;
		while(z < N){
			A[z++] = sc.nextInt();
		}
		int S = A.length%2 == 0 ? A.length/2 : 1 + A.length/2;
		MaxHeap maxHeap = new MaxHeap(S);
		MinHeap minHeap = new MinHeap(S);
		float M = 0.0f;
		for (int i : A) {
			if (maxHeap.HeapSize == minHeap.HeapSize) {
				if (i < M) {
					maxHeap.insert(i);
					M = maxHeap.getMax();
				} else {
					minHeap.insert(i);
					M = minHeap.getMin();
				}
			} else if (maxHeap.HeapSize < minHeap.HeapSize) {
				if (i < M) {
					maxHeap.insert(i);
				} else {
					int E = minHeap.extractMin();
					maxHeap.insert(E);
					minHeap.insert(i);
				}
				M = (float) ((maxHeap.getMax() + minHeap.getMin()) / 2.0);
			} else {
				if (i < M) {
					int E = maxHeap.extractMax();
					minHeap.insert(E);
					maxHeap.insert(i);
				} else {
					minHeap.insert(i);
				}
				M = (float) ((maxHeap.getMax() + minHeap.getMin()) / 2.0);
			}
			System.out.println(M);
		}
		System.out.println("done");
	}
}
