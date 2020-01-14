package oj120_139;

public class Lee_137_Self {
    public int singleNumber(int[] nums) {
        int b1 = 0, b2 = 0;
        for (int num : nums){
            b1 = (b1 ^ num) & ~ b2;
            b2 = (b2 ^ num) & ~ b1;
        }
        return b1;
    }
}
