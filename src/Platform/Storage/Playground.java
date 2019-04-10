package Platform;



public class Playground {
    public int[] moveZero(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int len = array.length;
        int slow = 0;
        int fast = 0;
        while (slow < len) {
            if (fast < len) {
                if (array[slow] == array[fast]) {
                    fast++;
                } else {
                    array[slow++] = array[fast++];
                }
            } else {
                array[slow++] = 0;
            }
        }
        return array;
    }
}
