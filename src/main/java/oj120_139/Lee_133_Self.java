package oj120_139;

import graph.Node;
import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 克隆图
 * 先克隆点，再克隆边
 */
public class Lee_133_Self {

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        ArrayList<Node> nodeList = new ArrayList<Node>();
        Map<Node, Node> nodeMap  = new HashMap<Node, Node>();
        // clone 点
        Node firstNode = new Node(node.val, new ArrayList<Node>());
        nodeList.add(node);
        nodeMap.put(node, firstNode);
        int count = 0;

        while (count < nodeList.size()){
            Node oldNode = nodeList.get(count++);
            for (Node neighbor : oldNode.neighbors){
                if (!nodeMap.containsKey(neighbor)){
                    Node newNeighbor = new Node(neighbor.val, new ArrayList<Node>());
                    nodeMap.put(neighbor, newNeighbor);
                    nodeList.add(neighbor);
                }
            }
        }
        //连接边
        for (Node oldNode : nodeList){
            Node newNode = nodeMap.get(oldNode);
            if (oldNode.neighbors != null){
                for (Node neighbor : oldNode.neighbors){
                    newNode.neighbors.add(nodeMap.get(neighbor));
                }
            }
        }
        return firstNode;
    }
}
