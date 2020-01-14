package oj21_39;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 26 从排序数组中移除重复元素，返回不重复的个数
 */
public class Lee_26_Self {

    
    /**
     * 使用index作为指针和返回值
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        Integer index = 0;
        if (nums.length <= 1){
            return nums.length;
        }
        for (int i = 0; i + 1 < nums.length; i++){
            if (nums[i] != nums[i + 1]){
                nums[++index]=nums[i + 1];
            }
        }
        System.out.println(Arrays.toString(nums));
        return index + 1;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
