abstract class Heap {
	int A[];
	int HeapSize;

	public Heap(int maxSize) {
		this.HeapSize = 0;
		this.A = new int[maxSize + 1];
	}

	public Heap() {

	}

	public abstract void heapify(int i);

	public abstract void insert(int N);

	public void buildHeapFromArray(int[] Array) {
		this.HeapSize = Array.length;
		int k = 1;
		A = new int[HeapSize + 1];
		for (int i : Array) {
			A[k++] = i;
		}

		int i = HeapSize / 2;
		while (i >= 1) {
			heapify(i);
			i--;
		}
	}
}
