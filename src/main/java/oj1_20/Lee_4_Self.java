package oj1_20;

import java.util.Map;

/**
 * 两个排序数组的中位数
 * 重点题
 * 首先要求第k个数，然后通过它求出中位数，中位数可能是一个也可能是两个
 * 所以分成两步，一部分计算中位数的位置，一部分计算第k个数是多少
 * 计算k个数是多少的时候采用删除法，每次删除k / 2 个数，
 * 删除哪一个数组中的数，需要判断两个数组的第k/ 2个数哪个比较小，小的话则代表是包含在k中的数
 * 而不是k 。这样删除到最后 k==1 此时我们两个数组中指向的位置比较，选择最小的即是k的值。
 */
public class Lee_4_Self {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        return (len1 + len2) % 2 == 0?(findKValue(nums1, 0, nums2, 0, (len1+len2)/2)
                + findKValue(nums1, 0, nums2, 0, (len1+len2)/2+1))/2:
                findKValue(nums1, 0, nums2, 0, (len1+len2)/2+1);
    }

    public double findKValue(int[] nums1, int m, int[] nums2,
                             int n, int k){
        // 两个头不能超过最大长度。
        if (m >= nums1.length){
            return nums2[n + k - 1];
        }
        if (n >= nums2.length){
            return nums1[m + k - 1];
        }
        if (k == 1){
            return Math.min(nums1[m], nums2[n]);
        }
        int nums1Value = (nums1.length- m ) >= k/2? nums1[m + k / 2 - 1]:Integer.MAX_VALUE;
        int nums2Value = (nums2.length- n ) >= k/2? nums2[n + k / 2 - 1]:Integer.MAX_VALUE;
        if (nums1Value < nums2Value){
            return findKValue(nums1, m + k / 2, nums2, n, k - k / 2);
        }else {
            return findKValue(nums1, m, nums2, n + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        Lee_4_Self self = new Lee_4_Self();
        System.out.println(self.findKValue(nums1, 0, nums2, 0, 2));

    }
}
