package LC.LCPkg;

public class ArrayGenerator {
    public static int[][] deserialize(String data) {
        if (data == null) {
            return null;
        }
        String str[] = data.split(",");
        if (ss.length == 0) {
            throw new IllegalArgumentException();
        }
        if (ss.length == 1 && ss[0].equals("#")) {
            return null;
        }
    }
}
