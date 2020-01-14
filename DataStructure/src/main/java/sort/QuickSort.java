package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 1 返回的中枢不作为下次排序的范围，
 * 2.先调用partation再分段
 */
public class QuickSort {
    public void quickSort(int[] nums, int start, int end){
        if (start < end){
            int pivotloc = partitionSort(nums, start, end);
            quickSort(nums, start, pivotloc - 1);
            quickSort(nums, pivotloc+1, end);
        }
    }
    //分段数组排序
    public int partitionSort(int[] nums, int start, int end){
//        Random rand = new Random();
//        int partitionIndex = rand.nextInt((end - start) + 1) + start;
        int pivot = nums[start];
        while (start < end){
            while (start < end && nums[end] >= pivot){
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= pivot){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;//最后枢纽元放到low的位置
        return start;
    }
    public void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = end;
        nums[end] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 8, 4, 3, 6};
        QuickSort sort = new QuickSort();
        sort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
