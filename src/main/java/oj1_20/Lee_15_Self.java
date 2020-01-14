package oj1_20;

import java.util.*;

/**
 * 15.三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 *

 */
public class Lee_15_Self {


    /**
     * O(n^3)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> threeSumList = new ArrayList<List<Integer>>();
        if (nums.length <= 2){
            return threeSumList;
        }
        for(int i = 0; i < nums.length; i++){
            for (int j = i + 1; j <nums.length; j++){
                for (int k = j + 1; k < nums.length; k++){
                    if (nums[i] + nums[j] + nums[k] == 0){

                        List<Integer> list = Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]});
                        if (threeSumList.size() == 0){
                            threeSumList.add(list);
                        }else{
                            boolean flag = false;
                            for (int m = 0; m < threeSumList.size(); m++){
                                if (compareToList(threeSumList.get(m), list)){
                                    flag = true;
                                }
                            }
                            if (!flag){
                                threeSumList.add(list);
                            }

                        }

                    }
                }
            }
        }
        return  threeSumList;
    }

    /**
     * true 集合元素完全相同， false不相同
     * @param list1
     * @param list2
     * @return
     */
    public boolean compareToList(List<Integer> list1, List<Integer> list2){
        Collections.sort(list1);
        System.out.println("list1"+list1);
        Collections.sort(list2);
        System.out.println("list2"+list2);
        if (list1.size() != list2.size()){
            return false;
        }else {
            for (int i = 0; i < list1.size(); i++){
                if (list1.get(i) != list2.get(i)){
                    return false;
                }
            }
            return true;
        }
    }


    public List<List<Integer>> threeSum2(int[] nums){

        return null;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4,0,0};

        Lee_15_Self solve1 = new Lee_15_Self();
        System.out.println(solve1.threeSum1(nums));
    }
}
