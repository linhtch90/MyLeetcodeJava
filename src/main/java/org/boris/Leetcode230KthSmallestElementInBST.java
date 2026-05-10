package org.boris;

import org.boris.models.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode230KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            k--;
            if (k == 0) {
                return currentNode.val;
            }
            currentNode = currentNode.right;
        }
        return -1;
    }
}
