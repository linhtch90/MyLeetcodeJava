package org.boris;

import org.boris.models.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode297SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(queue);
    }

    private TreeNode build(Queue<String> queue) {
        String current = queue.poll();
        if (current.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(current));
        node.left = build(queue);
        node.right = build(queue);

        return node;
    }

}
