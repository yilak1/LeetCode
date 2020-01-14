package oj161_179;

import java.util.Arrays;

/**
 * 对撞指针
 */
public class Lee_167_Self {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            if (numbers[left] + numbers[right] == target) {
                break;
            }
            if ( numbers[left] + numbers[right] > target) {
                right--;
            }else {
                left++;
            }
        }
        return new int[]{left+1, right+1};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
    }
}
