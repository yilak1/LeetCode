package oj40_59;

/**
 * 跳跃游戏2 ，最小跳跃次数
 * state 到达第i个位置的最小跳跃次数
 * function 能够达到i且 数量最小的然后+1作为该位置的值
 * initialValue f[0] = 0
 * f[n - 1]
 */
public class Lee_45_Self {
    public int jump(int[] nums) {
        int[] minSteps = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
            }
        }
        minSteps[0] = 0;
        for (int i = 1; i < nums.length; i++){
            int min = Integer.MAX_VALUE;
            for (int j = (i - max) < 0 ? 0 : (i - max); j < i; j++){
                if (nums[j] + j >= i && minSteps[j] < min){
                    min = minSteps[j];
                }
            }
            minSteps[i] = min + 1;
        }
        return  minSteps[nums.length - 1];
    }
}
