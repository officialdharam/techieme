abstract class Heap {
	int A[];
	int HeapSize;

	public Heap(int maxSize) {
		this.HeapSize = 0;
		this.A = new int[maxSize];
	}

	public Heap() {

	}

	public abstract void heapify(int i);

	public abstract void insert(int N) throws Exception;

	public void buildHeapFromArray(int[] Array) {
		this.HeapSize = Array.length;
		int k = 0;
		A = new int[HeapSize];
		for (int i : Array) {
			A[k++] = i;
		}

		int i = HeapSize / 2;
		while (i >= 0) {
			heapify(i);
			i--;
		}
	}
}
