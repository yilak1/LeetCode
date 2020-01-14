package oj120_139;

import util.DirectedGraphNode;

import java.sql.Driver;
import java.util.*;

/**
 * 拓扑排序
 */
public class Lint_127_Self {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        //建立点和入度hashmap
        Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        for (DirectedGraphNode node : graph){
            for (DirectedGraphNode neighbor : node.neighbors){
                if (map.containsKey(neighbor)){
                    map.put(neighbor, map.get(neighbor) + 1);
                }else {
                    map.put(neighbor, 1);
                }
            }
        }
        System.out.println(map);
        //加入入度为0 的点
        for (DirectedGraphNode node : graph){
            if (!map.containsKey(node)){
                queue.offer(node);
            }
        }
        //每次出队,找到一个neighbor则对应的入度计数减去1，当为0的时候加入队列，
        // 并且graph删除该点。
        while (!queue.isEmpty()){
            DirectedGraphNode root = queue.poll();
            result.add(root);
            for (DirectedGraphNode neighbor : root.neighbors){
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0){
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }
}
