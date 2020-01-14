package oj120_139;

import util.TreeNode;

/**
 * 二叉树最大路径和
 * 难题
 * 单向路径最大值与总最大值
 * 重点思考，路径与左子树最大路径和又子树最大路径的联系
 * 共有有两种路径1.左子树的绕过左子树根节点的最大路径，
 *               2.以及左子树单向路径和根节点和右子树最大路径和。
 */
public class Lee_124_Self {

    private class TreeType{
        int singlePath;
        int maxPath;

        public TreeType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    public int maxPathSum(TreeNode root) {
        return divideConquer(root).maxPath;
    }

    public TreeType divideConquer(TreeNode root){
//        //属性初始值
//        TreeType treeType = new TreeType(0, Integer.MIN_VALUE);
        if (root == null){
            return new TreeType(0, Integer.MIN_VALUE);
        }
        //出口
        //divide
        TreeType treeTypeLeft = divideConquer(root.left);
        TreeType treeTypeRight = divideConquer(root.right);

        //conquer
        int singlePath = Math.max(treeTypeLeft.singlePath, treeTypeRight.singlePath) + root.val;
        //精髓,如果最大路径小于0 则改成0，表示删去这段路径。
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(treeTypeLeft.maxPath, treeTypeRight.maxPath);
        maxPath = Math.max(maxPath, treeTypeLeft.singlePath + treeTypeRight.singlePath + root.val);
        return new TreeType(singlePath, maxPath);


    }
}
