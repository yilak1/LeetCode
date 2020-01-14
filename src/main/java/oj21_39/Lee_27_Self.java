package oj21_39;

import java.util.Arrays;

/**
 * 27 移除一个数组等于val的元素，而且需要原地修改数组并返回长度
 * 题理解错了，包含前几个就可以，不用排序！！！
 *
 */
public class Lee_27_Self {

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++){
            while (nums[i] == val && i < len){
                nums[i] = nums[--len];
            }
        }
        System.out.println(Arrays.toString(nums));
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
    }
}
