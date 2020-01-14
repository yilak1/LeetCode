package oj100_119;

import util.TreeNode;

/**
 * 求二叉树的最大深度
 * 分治法
 */
public class Lee_104_Self {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }

}
