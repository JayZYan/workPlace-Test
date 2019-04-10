package LC;

import LC.LCPkg.TreeGenerator;
import LC.LCPkg.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class LC0113 {
    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return result;
        }
        pathSum(root, sum, path, result);
        return result;
    }
    private static void pathSum(TreeNode root, int remains, List<Integer> path, List<List<Integer>> result) {

        path.add(root.val);
        if (remains == root.val && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }

        if (root.left != null) {
            pathSum(root.left, remains - root.val, path, result);
        }
        if (root.right != null) {
            pathSum(root.right, remains - root.val, path, result);
        }
        path.remove(path.size() - 1);

    }
    public static void main(String[] args) {
        String rootString = "5,4,8,11,#,13,4,7,2,#,#,5,1";
        TreeNode root = TreeGenerator.deserialize(rootString);
        int sum = 22;
        List<List<Integer>> result = pathSum(root, sum);
        for (List<Integer> path : result) {
            System.out.println(path);
        }

    }
}
