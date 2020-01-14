package oj100_119;

import util.TreeNode;

/**
 * 判断平衡二叉树，是则为true。
 * 左子树与右子树深度不能超过1
 * 重点题
 */
public class Lee_110_Self {
    public boolean isBalanced(TreeNode root) {
        return divideConquer(root) != -1;
    }

    public int divideConquer(TreeNode root){
        if (root == null){
            return 0;
        }

        //divide
        int left = divideConquer(root.left);
        int right = divideConquer(root.right);
        //conquer
        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
