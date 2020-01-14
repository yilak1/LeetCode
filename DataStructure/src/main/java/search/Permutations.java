package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列实现方式
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        permuteHelper(result, list, nums);
        return result;
    }

    public void permuteHelper(ArrayList<List<Integer>> result,
                              ArrayList<Integer> list,
                              int[] nums){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
        }
        for (int num : nums){
            if (!list.contains(num)){
                list.add(num);
                permuteHelper(result, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations self = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(self.permute(nums));
    }

}
