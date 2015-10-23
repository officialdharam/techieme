public class PublicHeapRunnerMaxHeap {

	public static void main(String[] args) throws Exception {
		Heap H = new MaxHeap();
		H.buildHeapFromArray(new int[] { 6, 2, 7, 14, 10, 12, 9, 4, 8, 3, 5 });
		System.out.println(Arrays.toString(H.A));
		
		int [] A = new int[] { 6, 2, 7, 14, 10, 12, 9, 4, 8, 3, 5 };
		Heap minHeap = new MinHeap(A.length);
		for(int i : A)
			minHeap.insert(i);
		System.out.println(Arrays.toString(minHeap.A));
	}
}
