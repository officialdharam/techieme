package com.amazon.sets._239;

public class MaxHeap extends Heap {

	public MaxHeap(int maxSize) {
		super(maxSize);
	}

	public MaxHeap() {

	}

	public double extractMax() throws Exception {
		if (HeapSize < 1)
			throw new Exception();
		double E = A[0];
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

	public double getMax() {
		return A[0];
	}

	@Override
	public void insert(double N) throws Exception {
		A[HeapSize] = Integer.MIN_VALUE;
		this.increaseKey(HeapSize++, N);
	}

	public void increaseKey(int i, double N) throws Exception {
		if (N < A[i])
			throw new Exception();

		A[i] = N;
		while (i > 0 && A[(i - 1) / 2] < A[i]) {
			int swapIndex = (i - 1) / 2;
			A[i] = A[i] + A[swapIndex];
			A[swapIndex] = A[i] - A[swapIndex];
			A[i] = A[i] - A[swapIndex];
			i = (i - 1) / 2;
		}
	}

	@Override
	public boolean find(double N, int i) {
		if (A[i] == N)
			return true;

		if (A[i] < N)
			return false;
		else
			return find(N, 2 * i + 1) || find(N, 2 * i + 2);
	}
}

abstract class Heap {
	double A[];
	int HeapSize;

	public Heap(int maxSize) {
		this.HeapSize = 0;
		this.A = new double[maxSize];
	}

	public Heap() {

	}

	public abstract void heapify(int i);

	public abstract void insert(double N) throws Exception;

	public abstract boolean find(double N, int i);

	public void buildHeapFromArray(int[] Array) {
		this.HeapSize = Array.length;
		int k = 0;
		A = new double[HeapSize];
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
