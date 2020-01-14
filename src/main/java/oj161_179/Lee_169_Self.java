package oj161_179;

public class Lee_169_Self {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums){
            if (count == 0){
                candidate = num;
                count = 1;
            }else if (candidate == num){
                count++;
            }else if (candidate != num){
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {

    }
}
