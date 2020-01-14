package search;

import java.security.KeyStore;
import java.util.Arrays;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;

public class BinarySearch  {

    /** 查询一个数
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target){
        if (nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start)/2;
            if (nums[mid] == target){
                return mid;
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

    /**
     * 查询左侧边界
     *
     */
    public static int searchLeftPosition(int[] nums, int target){
        if (nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (nums[mid] == target){
                end = mid;
            }else if (nums[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }

        if (nums[start] == target){
            return  start;
        }
        if (nums[end] == target){
            return end;
        }
        return  -1;
    }
    /**
     * 查询右侧边界
     * @param nums
     * @param target
     */
    public static int searchRightPosition(int[] nums, int target){
        if (nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
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
            return target;
        }
        return  -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 3, 4};
        Arrays.sort(nums);
        int target = 3;
        System.out.println("nums"+Arrays.toString(nums));
        int index = searchRightPosition(nums, target);
        System.out.println(index);
    }
}
