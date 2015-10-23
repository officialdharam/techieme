public class MinHeap extends Heap {

	public MinHeap(int maxSize) {
		super(maxSize);
	}

	public MinHeap() {
	}

	public int extractMin() throws Exception {
		if (HeapSize < 1)
			throw new Exception();
		int E = A[0];
		A[0] = A[HeapSize - 1];
		HeapSize--;
		heapify(0);
		return E;
	}

	@Override
	public void heapify(int i) {
		int L = 2 * i + 1;
		int R = L + 1;
		int swapIndex = i;
		if (L < HeapSize && A[L] < A[i])
			swapIndex = L;
		if (R < HeapSize && A[R] < A[swapIndex])
			swapIndex = R;
		if (swapIndex != i) {
			A[i] = A[i] + A[swapIndex];
			A[swapIndex] = A[i] - A[swapIndex];
			A[i] = A[i] - A[swapIndex];
			heapify(swapIndex);
		}
	}

	public int getMin() {
		return A[0];
	}

	@Override
	public void insert(int N) throws Exception {
		A[HeapSize] = Integer.MAX_VALUE;
		this.decreaseKey(HeapSize++, N);
	}

	public void decreaseKey(int i, int N) throws Exception {
		if (N > A[i])
			throw new Exception();

		A[i] = N;
		while (i > 0 && A[(i-1) / 2] > A[i]) {
			int swapIndex = (i-1) / 2;
			A[i] = A[i] + A[swapIndex];
			A[swapIndex] = A[i] - A[swapIndex];
			A[i] = A[i] - A[swapIndex];
			i = (i-1) / 2;
		}
	}

}
