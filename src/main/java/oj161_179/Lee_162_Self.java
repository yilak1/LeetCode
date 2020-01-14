package oj161_179;

/**
 * 找到一个峰值，
 * 思路，与mid相邻的值做比较来判断start，end如何移动
 */
public class Lee_162_Self {
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1]){
                if (nums[mid] > nums[mid + 1]){
                    return mid;
                }
                start = mid;
            }else{
                end = mid;
            }
        }
        if (nums[start] > nums[end]){
            return start;
        }else {
            return end;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
}
