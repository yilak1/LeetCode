package oj120_139;

/**
 * 分割回文串II，分割字符串，使得每一个子串都是回文串，并且计算最小切割数
 * state 前i个字符，最小的分割字符串数。
 * function： min（得到多个f[j]取最小值 ,如果j<i 并且 [j+1, i]闭区间的字符串是符文串）+1
 * initialValue f[s.length + 1] ,f[0] = 0;//当为空串时，字符串个数为0；
 * out
 */
public class Lee_132_Self {

    //可以把所有的字串都给计算出来是否是回文串，这样复杂度会降低
    public boolean isPalindrome(String s, int start, int end){
        boolean flag = true;
        while (start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public int minCut(String s) {
        int[] minStr = new int[s.length() + 1];
        minStr[0] = 0;
        for (int i = 0; i < s.length(); i++){
            int min = Integer.MAX_VALUE;
            for (int j = -1; j < i; j++){
                if (isPalindrome(s,j+1, i) && minStr[j + 1] < min){
                    min = minStr[j + 1];
                }
            }
            minStr[i + 1] = min + 1;
        }
        return minStr[s.length()] - 1;
    }

    public static void main(String[] args) {
        String s = "aab";
        Lee_132_Self self = new Lee_132_Self();
        System.out.println(self.minCut(s));
    }
}
