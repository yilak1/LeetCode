package oj100_119;

import util.TreeNode;

import java.util.*;

/**
 * BFS，宽度搜索
 * 使用Queue
 */
public class Lee_102_Self {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
        treeNodeQueue.offer(root);
        result.add(new ArrayList<Integer>(Arrays.asList(root.val)));
        while (!treeNodeQueue.isEmpty()){
            int queueLen = treeNodeQueue.size();
            System.out.println(queueLen);
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < queueLen; i++){
                TreeNode node = treeNodeQueue.poll();
                if (node.left != null){
                    list.add(node.left.val);
                    treeNodeQueue.offer(node.left);
                }
                if (node.right != null){
                    list.add(node.right.val);
                    treeNodeQueue.offer(node.right);

                }
            }
            if (list.size() > 0){
                result.add(list);
            }
        }
        return result;
    }
}
