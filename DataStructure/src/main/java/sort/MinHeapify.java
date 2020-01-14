package sort;

import java.util.Arrays;

/**
 * 最小堆的维护
 */
public class MinHeapify {

    //下标从0开始
    public static void  minHeapify(int[] A, int i){
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int smallest = i;
        if (left < A.length && A[left] < A[i]){
            smallest = left;
        }
        if (right < A.length && A[right] < A[smallest]){
            smallest = right;
        }
        if (smallest != i){
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;
            //交换后，i的位置是最小的，
            // 但是smallest的位置不一定是最小的，需要再次计算。
            minHeapify(A, smallest);
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 4, 5, 2, 9, 3, 8};
        int i = (A.length - 1) / 2;
        while (i >= 0){
            minHeapify(A, i);
            i--;
        }
        System.out.println(Arrays.toString(A));
    }
}
