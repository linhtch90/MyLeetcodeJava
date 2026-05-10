package org.boris;

import org.boris.models.TreeNode;

public class Leetcode104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
