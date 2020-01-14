package oj21_39;

import java.util.Arrays;

/**
 * 使用五行代码即可完成该题
 * 1.当i=0 时，直接写一次相同的值，i+1
 * 2.用当前访问的值与 i指的位置的值做比较，不同则修改，并且i+1；
 * 3 该算法修改的次数就等于nums的不重复元素长度
 */
public class Lee_26_standard {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums){
            if (i == 0 || n > nums[i - 1]){
                nums[i++] = n;
            }
        }
        return i;
    }
}
