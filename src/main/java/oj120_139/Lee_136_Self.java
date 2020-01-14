package oj120_139;

public class Lee_136_Self {
    public int singleNumber(int[] nums) {
        int flag = nums[0];
        for(int i = 1; i < nums.length; i++){
            flag ^= nums[i];
        }
        return flag;
    }

    public static void main(String[] args) {
        Lee_136_Self self = new Lee_136_Self();
        int[] nums = {2, 2, 1};
        System.out.println(self.singleNumber(nums));
    }
}
