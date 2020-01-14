package oj161_179;

public class Lee_172_Self {
    public int trailingZeroes(int n) {
        if(n >= 5){
            return n/5 + trailingZeroes(n / 5);
        }else {
            return 0;
        }
    }
}
