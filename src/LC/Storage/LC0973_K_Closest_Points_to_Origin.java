package LC;

import LC.LCPkg.ArrayPrinter;

import java.util.Comparator;
import java.util.PriorityQueue;
public class LC0973_K_Closest_Points_to_Origin {
    private static int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) {
            throw new IllegalArgumentException("Illegal Input");
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int o1Distance = (o1[0] * o1[0] + o1[1] * o1[1]);
                int o2Distance = (o2[0] * o2[0] + o2[1] * o2[1]);
                return o2Distance - o1Distance;
            }
        });

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
    public static void main(String[]  args) {
        int[][] points = {{1,3},{-2,2}};
        int K = 1;
        ArrayPrinter.print(kClosest(points, K));
    }
}
