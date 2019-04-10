package LC;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    private static class Element{
        int value;
        int rows;
        int cols;
        public Element(int value, int rows, int cols) {
            this.value = value;
            this.rows = rows;
            this.cols = cols;
        }
    }
    private static int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException("Input not valid");
        }
        Queue<Element> minHeap = new PriorityQueue<>(k, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.value - o2.value;
            }
        });

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        minHeap.offer(new Element(matrix[0][0], 0, 0));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Element cur = minHeap.poll();
            if (cur == null) {
                break;
            }
            int rows = cur.rows;
            int cols = cur.cols;
            if (rows + 1 < matrix.length && !visited[rows + 1][cols]) {
                minHeap.offer(new Element(matrix[rows + 1][cols], rows + 1, cols));
                visited[rows + 1][cols] = true;
            }
            if (cols + 1 < matrix[0].length && !visited[rows][cols + 1]) {
                minHeap.offer(new Element(matrix[rows][cols + 1], rows, cols + 1));
                visited[rows][cols + 1] = true;
            }
        }
        return minHeap.peek() == null ? -1 : minHeap.poll().value;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        int result = kthSmallest(matrix, k);
        System.out.print(result);
    }
}
