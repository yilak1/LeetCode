package oj220_239;

import util.TreeNode;

/**
 * 最近公共祖先
 * 有两种方法
 * 1.  缺点：需要parent指针，找到node节点，遍历到跟节点保存下来，然后倒着比较，出现第一个不相等
 *      的节点后则返回上一个相等的节点，则是最近公共祖先
 * 2. 分治法，分治找到两个节点，没有则返回空，
 *              然后依次向上返回，当左右节点都不为空，则是我们要找的最近公共祖先
 */
public class Lee_236_Self {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root== q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null){
            return root;
        }
        if (left != null){
            return left;
        }
        if (right != null){
            return right;
        }
        return null;
    }
}
