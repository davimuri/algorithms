package algorithms.trees;

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

        return buildSubtree(preorder, inorder);
    }

    private static BinaryNode buildSubtree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        BinaryNode root = new BinaryNode(preorder[0]);
        int endInorder = findIndex(root.value, inorder);
        int[] leftInorder = subArray(inorder, 0, endInorder);
        int[] leftPreorder = findSubArray(leftInorder, preorder);
        root.left = buildSubtree(leftPreorder, leftInorder);

        int[] rightInorder = subArray(inorder, endInorder + 1, inorder.length);
        int[] rightPreorder = findSubArray(rightInorder, preorder);
        root.right = buildSubtree(rightPreorder, rightInorder);

        return root;
    }

    private static int[] subArray(int[] original, int start, int end) {
        int[] subarray = new int[end - start];
        if (subarray.length == 0) return subarray;

        System.arraycopy(original, start, subarray, 0, end - start);
        return subarray;
    }

    private static int[] findSubArray(int[] toFind, int[] array) {
        int[] subarray = new int[toFind.length];
        int index = 0;
        for (int e : array) {
            for (int t: toFind) {
                if (e == t) {
                    subarray[index++] = e;
                    break;
                }
            }
            if (index == toFind.length) {
                break;
            }
        }

        return subarray;
    }

    private static int findIndex(int value, int[] traversal) {
        for (int i = 0; i < traversal.length; i++) {
            if (value == traversal[i]) {
                return i;
            }
        }
        return -1;
    }

}
