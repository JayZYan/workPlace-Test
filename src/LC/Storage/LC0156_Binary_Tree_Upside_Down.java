package LC;

import LC.LCPkg.TreeDrawer;
import LC.LCPkg.TreeGenerator;
import LC.LCPkg.TreeNode;

public class LC0156_Binary_Tree_Upside_Down {
    private static TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.right = root;     //root = 2, root.left = 4, 4 -> 2
        root.left.left = root.right;//4 -> 5
        root.left = null;
        root.right = null;
        return newRoot;


    }
    public static void main(String[] args) {
        String data = "1,2,3,4,5";

        TreeNode root = TreeGenerator.deserialize(data);
        TreeDrawer.draw(root);

        TreeNode result = upsideDownBinaryTree(root);
        TreeDrawer.draw(result);
    }
}
