package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CombineSum2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
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
            if (i != pos && candidates[i] == candidates[i - 1]){
                continue;
            }
            list.add(candidates[i]);
            combinationSumHelper(result, list, i + 1, target - candidates[i],
                                candidates);
            list.remove(list.size() - 1);
        }
    }
}
