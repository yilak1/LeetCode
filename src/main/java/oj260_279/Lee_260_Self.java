package oj260_279;

public class Lee_260_Self {
    public int[] singleNumber(int[] nums) {
        int diff = nums[0];
        for (int i = 1; i < nums.length; i++){
            diff ^= nums[i];
        }

        int[] results = {0, 0};
        //找出a^b二进制为1的位置，通过该位置，分成两组一组该位置为0，
        // 一组为1，a和b就分别在不同的组中，然后分别异或
        diff &= ((~diff) + 1);

        for (int num : nums){
            if ((diff & num) == 0){
                results[0] ^= num;
            }else {
                results[1] ^= num;
            }
        }
        return results;
    }
}
