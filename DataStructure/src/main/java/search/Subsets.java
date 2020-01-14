package search;

import java.util.ArrayList;

public class Subsets {
    public static void subsetsHelper(ArrayList<ArrayList<Integer>> results,
                               ArrayList<Integer> list,
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
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int pos = 0;
        int[] nums = {1, 2, 3};
        subsetsHelper(results, list, nums, pos);
        System.out.println(results);
    }
}
