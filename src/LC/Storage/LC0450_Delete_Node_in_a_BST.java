package LC;

import LC.LCPkg.TreeDrawer;
import LC.LCPkg.TreeGenerator;
import LC.LCPkg.TreeNode;

public class LC0450_Delete_Node_in_a_BST {
    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            } else {
                int value = smallestFromRight(root.right);
                root.val = value;
                root.right = deleteNode(root.right, value);
                return root;
            }
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            root.right = deleteNode(root.right, key);
            return root;
        }
    }
    private static int smallestFromRight(TreeNode root) {
        if (root.left == null) {
            return root.val;
        }
        return smallestFromRight(root.left);
    }
    public static void main(String[] args) {
        int key = 0;
        String data = "5,3,6,2,4,#,7";

        TreeNode root = TreeGenerator.deserialize(data);
        TreeDrawer.draw(root);
        if (root != null) {
            TreeNode result = deleteNode(root, key);
            TreeDrawer.draw(result);
        }
    }
}
