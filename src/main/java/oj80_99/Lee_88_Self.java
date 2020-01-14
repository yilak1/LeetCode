package oj80_99;

import java.util.Arrays;

/**
 * 合并两个排序数组
 */
public class Lee_88_Self {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int end = nums1.length - 1;
        while (index1 >= 0 || index2 >= 0){
            if (index1 >= 0 && index2 >= 0 && nums1[index1] <= nums2[index2]){
                nums1[end--] = nums2[index2--];
                continue;
            }
            if (index1 >= 0 && index2 >= 0 && nums1[index1] > nums2[index2]){
                nums1[end--] = nums1[index1--];
                continue;
            }
            if (index1 < 0){
                while ( index2 >= 0){
                    nums1[end--] = nums2[index2--];
                }
            }
            if (index2 < 0){
                while (index1 >= 0){
                    nums1[end--] = nums1[index1--];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        Lee_88_Self self = new Lee_88_Self();
        self.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
