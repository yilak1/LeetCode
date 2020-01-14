package oj40_59;

/**
 * 快速幂
 */
public class Lee_50_Self {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0){
            x = 1 / x;
            N = -N;
        }
        return recursion(x, N);
    }

    public double fastPower(double x, long n){
        double result = 1;
        while (n > 0){
            if ((n & 1) == 1){
                result = result * x;
            }
            n >>= 1;
            x = (x * x);
        }
        return result;
    }

    public double recursion(double x, long n){
        if (n ==1){
            return x;
        }
        if (n == 0){
            return 1;
        }
        double helf = recursion(x, n / 2);
        if ((n & 1) == 1){
            return helf * helf * x;
        }else {
            return helf * helf;
        }
    }

    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        Lee_50_Self self = new Lee_50_Self();
        System.out.println(self.myPow(x, n));
    }

}
