package oj21_39;

/**
 * search insert position
 * 查询插入位置，二分
 */
public class Lee_35_Self {

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }
        if (nums[start] >= target){
            return start;
        }
        if (nums[end] >= target){
            return end;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }
}
