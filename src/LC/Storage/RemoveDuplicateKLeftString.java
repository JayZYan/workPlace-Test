package LC;

public class RemoveDuplicateKLeftString {
    public static String removeDuplicateKLeftString(String s, int k) {
        if (s == null || s.length() <= k) {
            return s;
        }
        char[] arr = s.toCharArray();
        int len = arr.length;
        int slow = k;

        for (int fast = k; fast < len; fast++) {
            if (arr[slow - k] != arr[fast]) {
                arr[slow++] = arr[fast];
            }
        }
        return new String(arr, 0, slow);

    }
    public static void main(String[] args) {
        String s = "abbbbbcccccddd";
        int k = 2;

        System.out.println(removeDuplicateKLeftString(s, k));
    }
}
