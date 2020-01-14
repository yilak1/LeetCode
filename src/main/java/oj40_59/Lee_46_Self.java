package oj40_59;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 全排列，回溯法：swap(所有的可能的排列)，交换后要复位
 * 重点：int[] nums 如何插入到List中，需要借助ArrayList<Integer> 实现自动装箱
 * 然后使用Collection.swap对ArrayList交换。
 */
public class Lee_46_Self {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num : nums){
            list.add(num);
        }
        permuteHelper(results, list, 0);
        return results;
    }

    public void permuteHelper(List<List<Integer>> results,
                               ArrayList<Integer> nums,
                               int pos){
        if (pos == nums.size()){
            results.add(new ArrayList<Integer>(nums));
        }

        for (int i = pos; i < nums.size(); i++){
            Collections.swap(nums, pos, i);
            permuteHelper(results, nums, pos + 1);
            Collections.swap(nums, pos, i);
        }
    }


    public static void main(String[] args) {
        Lee_46_Self self = new Lee_46_Self();
        int[] nums = {1, 2, 3};
        System.out.println(self.permute(nums));
    }

}
