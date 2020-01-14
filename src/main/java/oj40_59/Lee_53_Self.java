package oj40_59;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 最大和子数组
 */
public class Lee_53_Self {
    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length + 1];
        f[0] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (f[i] < 0){
                f[i + 1] = nums[i];
            }else {
                f[i + 1] = nums[i] + f[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length + 1; i++){
            if (f[i] > max){
                max = f[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Lee_53_Self self = new Lee_53_Self();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(self.maxSubArray(nums));
    }
}
