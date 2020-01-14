package oj120_139;

import oj80_99.Lee_98_Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和
 * dfs divide conquer 动态
 */
public class Lee_120_Self {
    //自底向上
    public int minimumTotal(List<List<Integer>> triangle) {
        int low = triangle.size();
        int high = triangle.get(low - 1).size();
        int[][] f =  new int[low][high];
        for (int i = 0; i < low; i++){
            f[low - 1][i] = triangle.get(low - 1).get(i);
        }
        for (int i = low - 2; i >= 0; i --){
            for (int j = 0; j <= i; j++){
                f[i][j] = Math.min(f[i + 1][j], f[i+1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return f[0][0];
    }

    //自顶向下
    public int minimumTotal2(List<List<Integer>> triangle) {
        int low = triangle.size();
        int high = triangle.get(low - 1).size();
        int[][] f = new int[low + 1][high + 1];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < low; i++){
            for (int j = 0; j <= i; j++){
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if (j - 1 >=0){
                    left = f[i - 1][j - 1];
                }
                if (j <= i - 1){
                    right = f[i - 1][j];
                }
                f[i][j] = Math.min(left, right) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < high; i++){
            if (f[low - 1][i] < min){
                min = f[low - 1][i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> trangle = new ArrayList<List<Integer>>();
        trangle.add(Arrays.asList(new Integer[]{2}));
        trangle.add(Arrays.asList(new Integer[]{3, 4}));
        trangle.add(Arrays.asList(new Integer[]{6, 5, 7}));
        trangle.add(Arrays.asList(new Integer[]{4, 1, 8, 3}));
        Lee_120_Self self = new Lee_120_Self();
        System.out.println(self.minimumTotal2(trangle));
    }
}
