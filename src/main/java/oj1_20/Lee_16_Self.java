package oj1_20;

import java.util.Arrays;

/**
 * 3Sum Closest
 * 选三个数，找到最接近target的。假定只有唯一的答案
 *
 * 解题思路，由于是绝对值，会产生两种值，所以要保留两个值。一种是大于target的最小值，
 * 一种是小于target的最小值，遍历结束后，返回这两个值中最小的值
 */
public class Lee_16_Self {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int pos = Integer.MAX_VALUE;
        int neg = Integer.MAX_VALUE;
        for (int i = 0; i+2< nums.length; i++){
            int left = i+1;
            int right = nums.length - 1;

            while (left < right){
                int temp = nums[left] +nums[right] + nums[i]-target;
                if (temp > 0){
                    if (pos > temp){
                        pos = temp;
                    }
                    right--;
                }else if (temp < 0){
                    if (neg > -temp){
                        neg = -temp;
                    }
                    left++;
                }else {
                    return target;
                }
            }
        }
        return pos > neg?  -neg+target:pos+target;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
