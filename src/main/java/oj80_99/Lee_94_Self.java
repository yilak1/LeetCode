package oj80_99;

import util.Stack;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历二叉树
 * 递归
 * 非递归
 * 分治
 */
public class Lee_94_Self {
    //非递归
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()){
            while (curt != null){
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }
}
