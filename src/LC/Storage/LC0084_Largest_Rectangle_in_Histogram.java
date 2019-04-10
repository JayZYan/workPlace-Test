package LC;


import java.util.Stack;

public class LC0084_Largest_Rectangle_in_Histogram {
    private static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int idx = 0; idx < len; idx++) {

            while (stack.peek() != -1 && heights[idx] < heights[stack.peek()]) {
                max = Math.max(max, heights[stack.pop()] * (idx - stack.peek() - 1));
            }
            stack.push(idx);
        }
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (len - stack.peek() - 1));
        }
        return max;

    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3,3,3,3};
        int result = largestRectangleArea(heights);
        System.out.println(result);
    }
}
