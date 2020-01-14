package oj21_39;

/**
 * 查询旋转数组
 * 一定是一个升序一个不升序。
 */
public class Lee_33_Self {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) { //左升序 等于是为了判断 left==mid的情况
                if (target < nums[mid] && target > nums[left]){
                    right = mid - 1;
                }else if (target == nums[mid]){
                    return mid;
                }else if (target == nums[left]){
                    return left;
                } else {
                    left = left + 1;
                }
            }else {         //右升序
                if (target > nums[mid] && target < nums[right]){
                    left = mid + 1;
                }else if (target == nums[mid]){
                    return mid;
                }else if (target == nums[right]){
                    return right;
                } else {
                    right = right - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        System.out.println(search(nums, 1));
    }
}
