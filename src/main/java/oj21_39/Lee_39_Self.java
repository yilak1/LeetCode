package oj21_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39 组合求和，（每个数字可以重复使用）
 * 排序：为了去重
 * 当sum == target result.add,
 * 当sum>= target回溯
 * 每次加和导致执行效率低
 */
public class Lee_39_Self {
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
        int sum = listSum(list);
        if (sum == target){
            results.add(new ArrayList<Integer>(list));
            return;
        }
        if (sum > target){
            return;
        }
        for (int i = pos; i < candidates.length; i++){
//            if(i > 0 && candidates[i - 1] == candidates[i]){
//                continue;
//            }
            list.add(candidates[i]);
            sumBackTrack(results, list, candidates, i, target);
            list.remove(list.size()-1);
        }
    }

    public int listSum(ArrayList<Integer> list){
        int sum = Integer.MIN_VALUE;
        if (list.size() == 0){
            return sum;
        }else {
            sum = 0;
            for (int ele : list){
                sum += ele;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Lee_39_Self self = new Lee_39_Self();
        self.combinationSum(candidates, 7);
    }
}
