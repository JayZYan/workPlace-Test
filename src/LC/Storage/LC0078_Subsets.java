package LC;

import java.util.ArrayList;
import java.util.List;

public class LC0078_Subsets {
    private static List<String> subsets1(char[] arr) {
        List<String> res = new ArrayList<>();
        //subsets1(arr, res, new StringBuilder(), 0);
        helper(arr, res, new StringBuilder(), 0);
        return res;
    }
    private static void subsets1(char[] arr, List<String> res, StringBuilder path, int index) {
        res.add(path.toString());

        for (int i = index; i < arr.length; i++) {
            path.append(arr[i]);
            subsets1(arr, res, path, i + 1);
            path.setLength(path.length() - 1);
        }
    }
    private static void helper(char[] arr, List<String> res, StringBuilder path, int index) {
        if (index == arr.length) {
            res.add(path.toString());
            return;
        }
        path.append(arr[index]);
        helper(arr, res, path, index + 1);
        path.setLength(path.length() - 1);
        helper(arr, res, path, index + 1);
    }
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        List<String> res = subsets1(arr);
        for (String path : res) {
            System.out.println(path);
        }
    }
}
