package oj220_239;

import java.util.ArrayList;
import java.util.List;

public class Lee_229_Self {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0){
            return result;
        }
        int candidate1 = nums[0], candidate2 = nums[0];
        int count1 = 0, count2 = 0;
        for (int num : nums){
            //先判断==num这样可以记住数组中只有两种元素的情况。
            //如果先判断count==0 的话，就会出现两个候选保存相同的元素，
            // 这样在数组中只有两个元素的情况下，有可能只保存了一个元素。
            if (candidate1 == num){
                count1++;
            }else if (candidate2 == num){
                count2++;
            }else if (count1 == 0){
                candidate1 = num;
                count1 = 1;
            }else if (count2 == 0){
                candidate2 = num;
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums){
            //如果两个候选数相同只加第一个
            if (candidate1 == num){
                count1++;
            }
            else if (candidate2 == num){
                count2++;
            }
        }

        if (count1 > nums.length / 3){
            result.add(candidate1);
        }
        if (count2 > nums.length / 3){
            result.add(candidate2);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        System.out.println(new Lee_229_Self().majorityElement(nums));
    }
}
