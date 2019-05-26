package algorithms.trees;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * You may assume that duplicates do not exist in the tree.
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/788/
 *
 * Idea:
 * The first element in preorder is the root.
 * Find the root in inorder array and the elements to its left are left subtree
 * Elements to its right are the right subtree
 */
public class BuildBinaryTreeGivenPreorderInorder {

    public static BinaryNode build(int[] preorder, int[] inorder) {

        Map<Integer, Integer> elementToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            elementToIndex.put(inorder[i], i);
        }

        return buildSubtree(preorder, inorder, 0, preorder.length - 1,
                0, inorder.length - 1, elementToIndex);
    }

    private static BinaryNode buildSubtree(int[] preorder, int[] inorder, int preorderStart, int preorderEnd,
                                           int inorderStart, int inorderEnd, Map<Integer, Integer> elementToIndex) {

        if (inorderStart > inorderEnd) {
            return null;
        }

        BinaryNode root = new BinaryNode(preorder[preorderStart]);

        int preorderLeftStart = preorderStart + 1;
        int inorderLeftStart = inorderStart;
        int inorderLeftEnd = elementToIndex.get(root.value) - 1;

        // distances of left subarrays should be equal:
        // inorderLeftEnd - inorderLeftStart == preorderLeftEnd - preorderLeftStart
        int preorderLeftEnd = inorderLeftEnd - inorderLeftStart + preorderLeftStart;

        int inorderRightStart = inorderLeftEnd + 2;
        int inorderRightEnd = inorderEnd;
        int preorderRightEnd = preorderEnd;
        int preorderRightStart = preorderLeftEnd + 1;

        root.left = buildSubtree(preorder, inorder, preorderLeftStart, preorderLeftEnd,
                inorderLeftStart, inorderLeftEnd, elementToIndex);
        root.right = buildSubtree(preorder, inorder, preorderRightStart, preorderRightEnd,
                inorderRightStart, inorderRightEnd, elementToIndex);

        return root;
    }

}
