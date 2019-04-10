package LC;

import LC.LCPkg.TreeDrawer;
import LC.LCPkg.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FibTree {
    TreeNode build(int n){
        //base case
        if (n == 0) return new TreeNode(0);
        if (n == 1) return new TreeNode(1);
        TreeNode root = new TreeNode(n);
        root.left = build(n-1);
        root.right = build(n-2);
        return root;

    }
    public static void main(String[] args) {
//        FibTree test = new FibTree();
//        TreeDrawer.draw(test.build(3));

//        int[][] matrix = new int[1][0];
//        System.out.println(matrix.length);
//        System.out.println(matrix[0].length);
//
//        System.out.println(matrix[0][0]);

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        String s = "1 2 3";

        StringBuilder sb = new StringBuilder();
        sb.append("a");
        String res = sb.toString();

        System.out.println(sb);
    }

}
