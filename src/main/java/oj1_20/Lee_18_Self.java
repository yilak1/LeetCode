package oj1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和：参照三数之和的解法
 * 一次就ac，开心！！
 */
public class Lee_18_Self {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i + 3 < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i+1; j + 2< nums.length; j++){
                if (j > i+1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right){
                    int temp = nums[i] + nums[j] + nums[left]+ nums[right] - target;
                    if (temp == 0){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left ++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }else if (temp > 0){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
}
