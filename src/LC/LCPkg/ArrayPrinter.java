package LC.LCPkg;

import java.util.Arrays;

public class ArrayPrinter {
    public static void print(int[][] array) {
        if (array == null || array.length == 0 || array[0] == null || array[0].length == 0) {
            System.out.println("Null");
            return;
        }
        for (int[] path : array) {
            System.out.println(Arrays.toString(path));
        }
        System.out.println();
    }
}
