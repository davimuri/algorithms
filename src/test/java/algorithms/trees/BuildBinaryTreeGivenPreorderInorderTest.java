package algorithms.trees;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BuildBinaryTreeGivenPreorderInorderTest {

    @Test
    public void testCase1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BinaryNode root = BuildBinaryTreeGivenPreorderInorder.build(preorder, inorder);
        assertEqualElementsAndOrder(inorder, BinaryTreeTraversals.inorder(root, n -> n.value));
    }

    @Test
    public void testMinimumTree() {
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryNode root = BuildBinaryTreeGivenPreorderInorder.build(preorder, inorder);
        assertEqualElementsAndOrder(inorder, BinaryTreeTraversals.inorder(root, n -> n.value));
    }

    @Test
    public void testSamePreorderInorderLength2() {
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};
        BinaryNode root = BuildBinaryTreeGivenPreorderInorder.build(preorder, inorder);
        assertEqualElementsAndOrder(inorder, BinaryTreeTraversals.inorder(root, n -> n.value));
    }

    @Test
    public void testDifferentPreorderInorderLength2() {
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
        BinaryNode root = BuildBinaryTreeGivenPreorderInorder.build(preorder, inorder);
        assertEqualElementsAndOrder(inorder, BinaryTreeTraversals.inorder(root, n -> n.value));
    }

    @Test
    public void testSamePreorderInorderLength3() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {1, 2, 3};
        BinaryNode root = BuildBinaryTreeGivenPreorderInorder.build(preorder, inorder);
        assertEqualElementsAndOrder(inorder, BinaryTreeTraversals.inorder(root, n -> n.value));
    }

    @Test
    public void testDifferentPreorderInorderLength3() {
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};
        BinaryNode root = BuildBinaryTreeGivenPreorderInorder.build(preorder, inorder);
        assertEqualElementsAndOrder(inorder, BinaryTreeTraversals.inorder(root, n -> n.value));
    }

    @Test
    public void testSamePreorderInorderLength4() {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {1, 2, 3, 4};
        BinaryNode root = BuildBinaryTreeGivenPreorderInorder.build(preorder, inorder);
        assertEqualElementsAndOrder(inorder, BinaryTreeTraversals.inorder(root, n -> n.value));
    }

    @Test
    public void testDifferentPreorderInorderLength4() {
        int[] preorder = {3, 2, 1, 4};
        int[] inorder = {1, 2, 3, 4};
        BinaryNode root = BuildBinaryTreeGivenPreorderInorder.build(preorder, inorder);
        assertEqualElementsAndOrder(inorder, BinaryTreeTraversals.inorder(root, n -> n.value));
    }

    @Test
    public void testFullBinaryTree() {
        int[] preorder = {25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90};
        int[] inorder = {4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90 };
        BinaryNode root = BuildBinaryTreeGivenPreorderInorder.build(preorder, inorder);
        assertEqualElementsAndOrder(inorder, BinaryTreeTraversals.inorder(root, n -> n.value));
    }


    private void assertEqualElementsAndOrder(int[] expected, List<Integer> actual) {
        assertEquals(expected.length, actual.size());

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i).intValue());
        }
    }
}
