package oj21_39;

import java.util.Arrays;

/**
 * 下一个大的字典数，常数记忆
 */
public class Lee_31_Self {

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if (i < 0){
            Arrays.sort(nums);
            return;
        }
        int low = i;

        for (int j = nums.length - 1; j > low; j--){
            if (nums[j] > nums[i]){
                swap(nums, j, i);
                break;
            }
        }
        reverse(nums, i + 1, nums.length - 1);
    }
    public static void reverse(int[] nums, int low, int high){
        while (low < high){
            swap(nums, low++, high--);
        }
    }

    public static void swap(int[] nums, int ele1, int ele2){
        int temp = nums[ele1];
        nums[ele1] = nums[ele2];
        nums[ele2] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {5, 1, 1};
        nextPermutation(nums);
    }
}
