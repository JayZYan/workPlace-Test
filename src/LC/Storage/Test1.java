package LC;

import LC.LCPkg.TreeGenerator;
import LC.LCPkg.TreeNode;


public class Test1 {

    public static void main(String[] args) {
        String input = "1,#,2,#,#";
        TreeNode root = TreeGenerator.deserialize(input);   //construct a tree
        String output = TreeGenerator.serialize(root);      //print a tree, make it to be string
        //in order to decrease IO;

        System.out.println(output);

        output = TreeGenerator.serialize(TreeGenerator.deserialize(output));
        System.out.println(output);
    }
}
