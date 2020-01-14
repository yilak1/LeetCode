package oj80_99;

import util.CreateTree;
import util.Stack;
import util.TreeNode;

import java.util.ArrayList;

/**
 * 验证二叉搜索树
 * 分治法没有写出来，使用中序遍历法，二叉搜索树中序遍历是升序的。
 */
public class Lee_98_Self {
    /*private class ResultType{
        int minValue;
        int maxValue;

        public ResultType(int minValue, int maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }*/
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curt = root;
        TreeNode pre = null;
        //该curt != null 是为了在程序最开始stack为空，不能循环
        while (curt != null || !stack.empty()){
            while (curt != null){
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            if (pre != null && pre.val >= curt.val){
                return false;
            }
            pre = curt;
            curt = curt.right;
        }
        return true;
    }

    //递归式中序遍历
    public void interOrderTraverse(TreeNode root){
        if (root == null){
            return;
        }
        interOrderTraverse(root.left);
        //result.add(root.val);
        interOrderTraverse(root.right);
    }
    //非递归式中序遍历
    public void interOrderNoRecursion(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curt = root;
        TreeNode pre = null;
        //该curt != null 是为了在程序最开始stack为空，不能循环
        while (curt != null || !stack.empty()){
            while (curt != null){
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            //result.add(curt.val);
            curt = curt.right;
        }
    }


    public static void main(String[] args) {
        String tree = "[5,1,4,null,null,3,6]";
        //[10,5,15,null,null,6,20]
        TreeNode node = CreateTree.stringToTreeNode(tree);
        Lee_98_Self self = new Lee_98_Self();
        self.interOrderNoRecursion(node);
        //System.out.println(self.isValidBST(node));
        //System.out.println(self.result);
    }
}
