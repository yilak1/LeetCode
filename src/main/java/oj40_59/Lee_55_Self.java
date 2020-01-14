package oj40_59;

/**
 * 跳跃游戏，你可以跳的最大步数是你当前位置数组的值
 * state 该位置的前i个位置是否可以到达
 * function or(这几个位置中存在一个可以到达的则为true)
 * initialValue f[0]=true;f[length]
 * end f[n]
 */
public class Lee_55_Self {
    public boolean canJump(int[] nums) {
        int max = Integer.MIN_VALUE;
        //选择最大步，可以减少程序运行次数
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
            }
        }
        boolean[] f = new boolean[nums.length];
        f[0] = true;
        for (int i = 1; i < nums.length; i++){
            f[i] = false;
            for (int j = (i - max)< 0 ? 0: (i - max); j < i; j++){
                if (f[j] && j + nums[j] >= i){
                    f[i] = true;
                }
            }
        }
        return f[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Lee_55_Self self = new Lee_55_Self();
        System.out.println(self.canJump(nums));
    }
}
