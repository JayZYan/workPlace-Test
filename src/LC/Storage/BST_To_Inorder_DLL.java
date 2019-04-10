package LC;

import LC.LCPkg.TreeDrawer;
import LC.LCPkg.TreeGenerator;
import LC.LCPkg.TreeNode;

public class BST_To_Inorder_DLL {
    static TreeNode res = null;
    static TreeNode prev = null;

    public static TreeNode convertBSTtoDLL(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        if (root.left == null || root.right == null) {
            return root;
        }
        dfs(root);
        return res;
    }
    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev == null) {
            res = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        dfs(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = TreeGenerator.deserialize("5,3,9,1,4,7,12");
        TreeDrawer.draw(root);

        TreeNode head = convertBSTtoDLL(root);
        String s;
        Boolean s;

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
    }
}
