package LC;

import LC.LCPkg.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class TreeGeneratorStack {
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] tokens = data.split(",");
        if (tokens.length == 1 && tokens[0].equals("#")) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = new TreeNode(Integer.valueOf(tokens[0]));
        TreeNode root = cur;

        stack.push(cur);
        int i = 1;
        int len = tokens.length;
        while (i < len) {
            while (i < len && !tokens[i].equals("#")) {
                cur.left = new TreeNode(Integer.valueOf(tokens[i++]));
                cur = cur.left;
                stack.push(cur);
            }
            while (i < len && tokens[i].equals("#")) {
                i++;
                if (stack.isEmpty()) {
                    break;
                }
                cur = stack.pop();
            }
            if (i < len) {
                cur.right = new Tree
            }
        }

    }
}
