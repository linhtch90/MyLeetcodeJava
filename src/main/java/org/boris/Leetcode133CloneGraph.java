package org.boris;

import org.boris.models.Node;

import java.util.HashMap;
import java.util.Map;

public class Leetcode133CloneGraph {
    private final Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);

        for (Node i : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(i));
        }

        return clonedNode;
    }
}
