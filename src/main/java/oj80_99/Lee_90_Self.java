package oj80_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lee_90_Self {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsetsHelper(results, list, nums, 0);

        return results;
    }
    public void subsetsHelper(List<List<Integer>> results,
                              List<Integer> list,
                              int[] nums,
                              int pos){
        results.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++){
            if (i != pos && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);

            subsetsHelper(results, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }
}
