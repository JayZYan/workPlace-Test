package LC;

import LC.LCPkg.TreeGenerator;
import LC.LCPkg.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class LC0272_Closest_Binary_Search_Tree_Value_II {
    private static List<Integer> closestKValues(TreeNode root, double target, int k) {
        if (root == null) {
            throw new IllegalArgumentException("invalid root");
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> {
            double diff1 = Math.abs(o1 - target);
            double diff2 = Math.abs(o2 - target);
            return Double.compare(diff1, diff2);
        });
        helper(root, maxHeap);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll());
        }
        return result;
    }
    private static void helper(TreeNode root, PriorityQueue<Integer> maxHeap) {
        if (root == null) {
            return;
        }
        maxHeap.offer(root.val);
        helper(root.left, maxHeap);
        helper(root.right, maxHeap);
    }

    public static void main(String[] args) {
        String bst = "4,2,5,1,3";
        TreeNode root = TreeGenerator.deserialize(bst);
        double target = 3.714286;
        int k = 2;

        List<Integer> result = closestKValues(root, target, k);
        System.out.println(result);

    }
}
