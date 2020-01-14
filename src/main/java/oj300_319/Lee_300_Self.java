package oj300_319;

/**
 * 最长升序子序
 * state： 返回前i个数以第i个结尾的升序序列长度。
 * function  如果前i个数都比i小则f[i] = 1, 如果存在一个或多个bi它小的则求最大的一个，然后返回 f[j]+1;
 * initialValue f[0] = 1;
 * out max(f[0...length -1])
 */
public class Lee_300_Self {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] countLIS = new int[nums.length];
        countLIS[0] = 1;
        for (int i = 1; i < nums.length; i++){
            int max = 0;
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i] && countLIS[j] > max){
                    max = countLIS[j];
                }
            }
            countLIS[i] = max + 1;
        }
        int max = 1;
        for (int i = 0; i < countLIS.length; i++){
            if (countLIS[i] > max){
                max = countLIS[i];
            }
        }
        return  max;
    }
}
