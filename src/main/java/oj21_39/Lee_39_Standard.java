package oj21_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 标准答案，用减法，且不需要每次都加和操作，该操作导致效率降低
 */
public class Lee_39_Standard {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        if (target == 0){
            results.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < 0){
            return;
        }
        for (int i = pos; i < candidates.length; i++){
//            if(i > 0 && candidates[i - 1] == candidates[i]){
//                continue;
//            }
            list.add(candidates[i]);
            sumBackTrack(results, list, candidates, i, target - candidates[i]);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Lee_39_Standard self = new Lee_39_Standard();
        self.combinationSum(candidates, 7);
    }
}
