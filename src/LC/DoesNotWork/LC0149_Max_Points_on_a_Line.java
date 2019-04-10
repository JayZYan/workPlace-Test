package LC;

public class LC0149_Max_Points_on_a_Line {
    static class Point {
        int x;
        int y;
        Point() {
            x = 0;
            y = 0;
        }
        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    private static int maxPoints(Point[] points) {


    }
    public static void main(String[] args) {

        Point[] points = {new Point(1,1),
                          new Point(2,2),
                          new Point(3,3)};
        int result = maxPoints(points);
        System.out.println(result);
    }
}
