package oj40_59;

import oj21_39.Lee_39_Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合求和
 * 每个数字只能用一次
 */
public class Lee_40_Self {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        sumBackTrack(results, list, candidates, 0, target);
        System.out.println(results);
        return results;
    }

    public void sumBackTrack(List<List<Integer>> results,
                              ArrayList<Integer> list,
                              int[] candidates,
                              int pos,
                              int target){
        if (target < 0){
            return;
        }
        if (target == 0){
            results.add(new ArrayList<Integer>(list));
        }

        for (int i = pos; i < candidates.length; i++){
            if (i > pos && candidates[i] == candidates[i - 1]){
                continue;
            }
            list.add(candidates[i]);
            sumBackTrack(results, list, candidates, i + 1, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Lee_40_Self self = new Lee_40_Self();
        self.combinationSum2(candidates, target);
    }
}
