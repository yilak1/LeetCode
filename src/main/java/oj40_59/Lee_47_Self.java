package oj40_59;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 全排列，包括重复的元素，列出不重复的全排列。
 * [1, 1, 2, 2], 每一遍的排列要确定当前pos和i，判断i之前是否有和i索引位置相同的数
 * 如果有则continue
 */
public class Lee_47_Self {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num : nums){
            list.add(num);
        }
        backTrack(results, list, 0);
        return results;
    }

    public void backTrack(List<List<Integer>> results,
                           ArrayList<Integer> nums,
                           int pos){
        if (pos == nums.size()){
            results.add(new ArrayList<Integer>(nums));
        }

        for (int i = pos; i < nums.size(); i++){
            if (!check(nums, pos, i)){
                continue;
            }
            Collections.swap(nums, i, pos);
            backTrack(results, nums, pos + 1);
            Collections.swap(nums, i, pos);
        }
    }

    public boolean check(ArrayList<Integer> nums, int pos, int i){
        if (i > pos){
            for (int j = pos; j < i; j++){
                if (nums.get(j) == nums.get(i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Lee_47_Self self = new Lee_47_Self();
        int[] nums = {1, 1, 2, 2};
        System.out.println(self.permuteUnique(nums));
    }

}
