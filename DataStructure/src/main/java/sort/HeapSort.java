package sort;

import java.util.Arrays;

public class HeapSort {

    public void heapSort(int[] A){
        int heapSize = A.length;
        //初始化堆
        for (int i = (A.length-1)/2; i >=0; i--){
            maxHeapify(A, heapSize, i);
        }
        //每次构建一个最大堆，放到最后一位
        for (int i = A.length - 1; i >=1; i--){
            swap(A, 0, i);
            heapSize--;
            maxHeapify(A, heapSize, 0);
        }
    }
    //从0开始
    public void maxHeapify(int[] A, int heapSize, int i){
        int left  = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < heapSize && A[left] > A[i]){
            largest = left;
        }
        if (right < heapSize && A[right] > A[largest]){
            largest = right;
        }
        if (largest != i){
            swap(A, i, largest);
            maxHeapify(A, heapSize, largest);
        }
    }
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {3, 5, 7, 9, 2, 4, 6, 3, 8};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(A);
        System.out.println(Arrays.toString(A));
    }
}
