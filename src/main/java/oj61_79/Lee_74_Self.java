package oj61_79;

/**
 *  Search a 2D Matrix
 *  二分查找题
 *  思路：
 *  n*m的矩阵，想成是一维数组res=matrix[mid / m][ mid %m]
 *  然后通过二分查找即可
 */
public class Lee_74_Self {
    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        if (m == 0||matrix[0].length == 0){
            return false;
        }
        int n = matrix[0].length;
        int start = 0;
        int end = n * m - 1;
        while (start +1 < end) {
            int mid = start + (end - start) / 2;
            int midRes = matrix[mid/n][mid % n];

            if (midRes == target){
                return true;
            }else if (midRes < target){
                start = mid;
            }else {
                end = mid;
            }
        }
        int starRes = matrix[start / n][start % n];
        int endRes = matrix[end / n][end % n];
        if (starRes == target || endRes == target){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 1}};
        System.out.println(nums.length);
        System.out.println(searchMatrix(nums, 0));
    }
}
