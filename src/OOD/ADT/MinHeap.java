package OOD.ADT;

import java.util.Arrays;

public class MinHeap {      //TODO:GENERIC
    private int[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MinHeap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can not be less than 1");
        }
        array = new int[capacity];
        size = 0;
    }

    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }
    public MinHeap(int[] array) {
        this.array = Arrays.copyOf(array, array.length * 2);
        size = array.length;
        heapify();
    }
    public void offer(int val) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = val;
        percolateUp(size);
        size++;
    }
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int topElement = array[0];
        array[0] = array[size - 1];
        percolateDown(0);
        size--;
        return topElement;
    }
    public Integer peek() {
        return size == 0 ? null : array[0];
    }
    public void update(int index, int val) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Your index should within 0 and size - 1");
        }
        array[index] = val;
        percolateUp(index);
        percolateDown(index);
    }
    private void heapify() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            percolateDown(i);
        }
    }
    private void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] > array[index]) {
                swap(parent, index);
            } else {
                break;
            }
            index = parent;
        }
    }
    private void percolateDown(int index) {
        while (index <= (size -2) / 2) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int swapIndex = left;
            if (right <= size - 1) {
                if (array[right] < array[left]) {
                    swapIndex = right;
                }
            }
            if (array[index] > array[swapIndex]) {
                swap(index, swapIndex);
            } else {
                break;
            }
            index = swapIndex;
        }
    }
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

