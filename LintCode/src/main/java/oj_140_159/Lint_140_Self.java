package oj_140_159;

/**
 * 1 转成long型，不然一溢出
 * 2. 考虑n=0时，
 */
public class Lint_140_Self {
    public int fastPower(int a, int b, int n) {
        // write your code here
        long result = 1;
        long temp = a;
        while (n != 0){
            //相当于n % 2 == 1
            if ((n & 1) == 1){
                result = (result * temp) % b;
            }
            n >>= 1;
            temp = (temp * temp) % b;
        }
        //考虑到n=0时，没有进入循环，所以在结果中要再次%b
        return (int)result % b;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 1;
        int n = 0;
        Lint_140_Self self = new Lint_140_Self();
        System.out.println(self.fastPower(a, b, n));
    }
}
