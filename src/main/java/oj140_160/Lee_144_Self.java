package oj140_160;

import util.CreateTree;
import util.Stack;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树先序遍历
 * 三种方式，遍历，非递归，分治
 *  Definition for a binary tree node.
 *  public class TreeNode {
 *       int val;
 *       TreeNode left;
 *       TreeNode right;
 *       TreeNode(int x) { val = x; }
 *   }
 */
public class Lee_144_Self {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        traversal(root, results);
        return results;
    }
    //遍历法
    public void traversal(TreeNode root, List<Integer> results){
        if (root == null){
            return;
        }
        results.add(root.val);
        traversal(root.left, results);
        traversal(root.right, results);
    }
    //分治法
    public List<Integer> preorderConquer(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        //divide
        List<Integer> left = preorderConquer(root.left);
        List<Integer> right = preorderConquer(root.right);
        //conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;

    }

    //非递归法
    public List<Integer> preorderNoRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> results = new ArrayList<Integer>();
        if (root == null){
            return results;
        }
        stack.push(root);
        while (!stack.empty()){
            int size = stack.size();
            for (int i = 0; i < size; i++){
                TreeNode node = stack.pop();
                results.add(node.val);
                if (node.right != null){
                    stack.push(node.right);
                }
                if (node.left != null){
                    stack.push(node.left);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode node = CreateTree.stringToTreeNode("[10,5,15,null,null,6,20]");
        Lee_144_Self self = new Lee_144_Self();
        List<Integer> list = self.preorderTraversal(node);
        System.out.println(list);
    }
}
