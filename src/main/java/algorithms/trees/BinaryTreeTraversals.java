package algorithms.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BinaryTreeTraversals {

    public static <T> List<T> inorder(BinaryNode root, Function<BinaryNode, T> visitor) {
        List<T> traversalResult = new ArrayList<>();
        inorder(root, visitor, traversalResult);
        return traversalResult;
    }

    private static  <T> void inorder(BinaryNode node, Function<BinaryNode, T> visitor, List<T> traversalResult) {
        if (node == null) return;

        inorder(node.left, visitor, traversalResult);
        traversalResult.add(visitor.apply(node));
        inorder(node.right, visitor, traversalResult);
    }
}
