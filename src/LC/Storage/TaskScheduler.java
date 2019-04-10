package LC;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {



    public static int taskCooler(int[] nums, int cooling) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();

        // <value, index>
        //0,1,2,3,4
        //1,2,3,_,_,_,2,1     4
        /*1,2,3,2,1
        * <1,0>
        * <2,1>
        * <3,2>
        *
        * */

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int idxPrev = map.get(nums[i]);
                int curCool = i - idxPrev - 1;
                if (curCool <= cooling) {   //add time means decrement in previous
                    int moreTime = cooling - curCool;
                    count += moreTime;
                    //System.out.println(count);
                    updateMap(nums, map, idxPrev, moreTime);
                }
            }
            map.put(nums[i], i);
        }

        return count + nums.length;
    }
    private static void updateMap(int[] nums, Map<Integer, Integer> map, int end, int decrement) {
        for (int j = 0; j <= end; j++) {
            map.put(nums[j], map.get(nums[j]) - decrement);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,2,1,1};
        int cooling = 3;

        System.out.println(taskCooler(nums, cooling));
    }

}
