package oj61_79;

/**
 * 爬楼梯一次爬一个还是两个台阶，有多少种不同的方式爬到顶
 * state 到达第i个楼梯的方式种数
 * function f[i] = f[i - 1]+ f[i - 2];
 * initialValue f[n+1] f[0]=0 f[1]=1
 * end f[m]
 */
public class Lee_70_Self {
    public int climbStairs(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        if (n >= 2 ){
            f[2] = 2;
        }
        for (int i = 3; i < n+1; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
