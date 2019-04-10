package Platform;

import java.util.*;

public class PatternSort {
    public void patternSort(Integer[] array, Map<Integer, Integer> map) {
        Arrays.sort(array, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (map.containsKey(a) && map.containsKey(b)) {
                    return map.get(a) - map.get(b);
                } else if (map.containsKey(a)) {
                    return -1;
                } else if (map.containsKey(b)) {
                    return 1;
                } else {
                    return a - b;
                }
            }
        });
    }
}
