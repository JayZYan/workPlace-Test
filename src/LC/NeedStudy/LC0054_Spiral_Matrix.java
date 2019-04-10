package LC;

public class LC0054_Spiral_Matrix {
    private static void printSpiral(int n) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int layer = Math.min(Math.min(i,j), Math.min(n - 1 - i, n - 1 - j));
                if (i <= j) {
                    num = 1 + n * n - (n - 2 * layer) * (n - 2 * layer) + (i - layer) + (j - layer);
                    System.out.print(num + "\t");
                } else {
                    num = 1 + n * n - (n - 2 * (layer + 1)) * (n - 2 * (layer + 1)) - (i - layer) - (j - layer);
                    System.out.print(num + "\t");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 4;
        printSpiral(n);
    }
}
