package sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public ArrayList<Integer> mergeSort(int[] nums, int start, int end){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0){
            return result;
        }
        //退出条件
        if (start == end){
            result.add(nums[start]);
            return result;
        }
        int mid = (start + end) / 2;
        //divide
        ArrayList<Integer> left = mergeSort(nums, start, mid);
        ArrayList<Integer> right = mergeSort(nums, mid+1, end);
        //conquer
        return merge(left, right);
    }
    ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.size() && rightIndex <right.size()){
            if (left.get(leftIndex) <= right.get(rightIndex)){
                result.add(left.get(leftIndex));
                leftIndex++;
            }else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        if (leftIndex == left.size()){
            //subList 开闭确认一下
            result.addAll(right.subList(rightIndex, right.size()));
        }
        if (rightIndex == right.size()){
            result.addAll(left.subList(leftIndex, left.size()));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 2, 8, 4, 3, 6};
        //int[] nums2 = {2, 4, 6, 7, 8};
        MergeSort self = new MergeSort();
        System.out.println(self.mergeSort(nums1, 0, nums1.length - 1));
    }
}
