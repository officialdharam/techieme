public class PublicHeapRunnerMaxHeap {

	public static void main(String[] args) {
		Heap H = new MaxHeap();
		H.buildHeapFromArray(new int[] { 6, 2, 7, 14, 10, 12, 9, 4, 8, 3, 5 });
		System.out.println(Arrays.toString(H.A));
	}
}
