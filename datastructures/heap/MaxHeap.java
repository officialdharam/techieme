class MaxHeap extends Heap {

	public MaxHeap(int maxSize) {
		super(maxSize);
	}

	public MaxHeap() {

	}

	@Override
	public void heapify(int i) {
		int L = 2 * i;
		int R = L + 1;
		int swapIndex = i;
		if (L < HeapSize && A[L] > A[i])
			swapIndex = L;
		if (R < HeapSize && A[R] > A[swapIndex])
			swapIndex = R;
		if (swapIndex != i) {
			A[i] = A[i] + A[swapIndex];
			A[swapIndex] = A[i] - A[swapIndex];
			A[i] = A[i] - A[swapIndex];
			heapify(swapIndex);
		}
	}

	public int getMax() {
		return A[1];
	}

	@Override
	public void insert(int N) {
		A[++HeapSize + 1] = Integer.MIN_VALUE;
		this.increaseKey(HeapSize, N);
	}

	public void increaseKey(int i, int N) {
		A[i + 1] = N;
		heapify(i + 1);
	}
}
