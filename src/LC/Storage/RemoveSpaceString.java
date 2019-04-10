package LC;

public class RemoveSpaceString {
    public static String spaceRemover(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int slow = 0;

        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int fast = 0; fast < len; fast++) {
            if (arr[fast] != ' ' || (fast != 0 && arr[fast - 1] != ' ')) {
                arr[slow++] = arr[fast];
            }
        }
        if (slow == 0) {
            return "";
        }
        return arr[slow - 1] != ' ' ? new String(arr, 0, slow)
                                : new String(arr, 0, slow - 1);
    }

    public static void main(String[] args) {
        String s = "    you    get  offer   ha ha      ";
        char[] c = {'a','b','c'};
        System.out.println(new String(c, 0, 1));
        System.out.println(spaceRemover(s));
    }
}
