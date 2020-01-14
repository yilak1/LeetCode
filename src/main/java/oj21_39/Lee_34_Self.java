package oj21_39;

import java.util.ArrayList;
import java.util.Arrays;

public class Lee_34_Self {
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeftPosition(nums, target);
        int right = searchRightPosition(nums, target);
        return new int[]{left, right};
    }


    public int searchLeftPosition(int[] nums, int target){
        if (nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] == target){
                end = mid;
            }else if (nums[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }

        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }

    public int searchRightPosition(int[] nums, int target){
        if (nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end){
            mid =start + (end - start) / 2;
            if (nums[mid] == target){
                start = mid;
            }else if (nums[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }

        if (nums[end] == target){
            return end;
        }
        if (nums[start] == target){
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        Lee_34_Self self = new Lee_34_Self();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(self.searchRange(nums, target)));
    }
}
