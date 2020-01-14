package oj1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 重点理解题，
 * 用对撞指针实现，算法效率O(n^2)
 * 1. 对nums排序 nums 长度不能小于3，通过for(i; i +2 <nums.length)循环就可以排除
 * 2. 进行一次for循环，再生成两个指针left，right，指针一个指向当前循环的下一位，
 * 一个指向最末位， 通过计算和来判断left和right的指针移动，
 * 细节：在while(left < right )循环中 判断条件是小于，因为三个元素不重复，
 *       其次，先判断三个数和是否为0，可以先插入数据。然后left，和right移动。
 *       这样在判断去重的时候 left--就不会越界。
 * 3 去重，nums[i] == nums[i-1] 则需要去重跳过。
 *         当和为0 后，如果下一位left和当前的相同，就跳过
 *                      如果下一位right和当前相同也跳过。
 *          细节：每个while都要判断left< right,因为他们移动了。
 *
 */
public class Lee_15_standard {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i+2 < nums.length; i++){
            // 如果大于0或者 nums.le
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            if (nums[i]>0 ) {
                return res;
            }
            int left = i+1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right){
                if (nums[left] + nums[right]  == target){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right &&(nums[left] == nums[left - 1])) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }else if (nums[left] + nums[right] > target){
                    right--;
                }else  {
                    left++;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4,0,0};
        Lee_15_standard solve1 = new Lee_15_standard();
        System.out.println(solve1.threeSum(nums));
    }
}
