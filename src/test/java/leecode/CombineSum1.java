package leecode;

import java.util.ArrayList;
import java.util.List;

public class CombineSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        combinationSumHelper(result, list, 0, target, candidates);
        return result;
    }

    public void combinationSumHelper(ArrayList<List<Integer>> result,
                                      ArrayList<Integer> list,
                                      int pos,
                                     int target,
                                     int[] candidates){
        if (target < 0){
            return;
        }
        if (target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < candidates.length; i++){
            list.add(candidates[i]);
            combinationSumHelper(result, list, i, target - candidates[i],
                                candidates);
            list.remove(list.size() - 1);
        }
    }
}
