package oj61_79;

import java.util.ArrayList;
import java.util.List;

/**
 * 求子集，
 */
public class Lee_78_Self {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        subsetsHelper(results, list, nums, 0);
        return results;
    }
    public void subsetsHelper(List<List<Integer>> results,
                               List<Integer> list,
                               int[] nums,
                               int pos){
        results.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            subsetsHelper(results, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lee_78_Self solve = new Lee_78_Self();
        List<List<Integer>> results = solve.subsets( new int[]{1, 2, 3});
        System.out.println(results);
    }
}
