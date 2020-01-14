package oj120_139;

import java.util.Arrays;

public class Lint_130_Self {

    public void heapify(int[] A) {
        // write your code here
        int i = (A.length - 1) / 2;
        while (i >= 0){
            minHeapify(A, i);
            i--;
        }
    }

    public void  minHeapify(int[] A, int i){
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
        Lint_130_Self self = new Lint_130_Self();
        int[] A = {45,39,32,11};
        self.heapify(A);
        System.out.println(Arrays.toString(A));
    }
}
