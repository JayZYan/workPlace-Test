package LC;

import java.util.*;

public class MinimumSequenceAmazonOA {
    public static List<Integer> find(List<Character> inputList) {
        List<Integer> res = new ArrayList<>();
        if (inputList == null || inputList.size() == 0) {
            return res;
        }
        Map<Character, Integer> hash = new HashMap<>();
        //count the occurrences of each character
        //<char, count>
        Set<Character> set = new HashSet<>();
        for (char c : inputList) {
            if (!hash.containsKey(c)) {
                hash.put(c, 1);
            } else {
                hash.put(c, hash.get(c) + 1);
            }
        }

        int len = 0;
        for (char curChar : inputList) {
            len++;
            //char curChar = character;
            set.add(curChar);
            //remove 1 count from HashMap
            hash.put(curChar, hash.get(curChar) - 1);

            if (hash.get(curChar) == 0) {
                set.remove(curChar);
            }
            if (set.size() == 0) {  //reach break point
                res.add(len);
                len = 0;    //setBack len
            }
        }
        return res;
    }
    /*In order to get the sequence count from the list, first I used the hash map to count the occurrences of each character,
    then i iterate the whole list again, once we see a character, we minus 1 count in the map of this character. I also use a set to
    record the character type, once the count of the character becomes 0, I remove it from the set. Once I see the set becomes empty, which
    means it reach the break point, so that I store the length in the result, and reset the length.

    The time complexity is O(n)<count> + O(n)<iteration> = O(n) in this method if the length of the input list is n.
    * */


    public static void main(String[] args) {
        Character[] case1 = {'a', 'b', 'c'};
        List<Character> test1 = new ArrayList<>(Arrays.asList(case1));
        System.out.println(find(test1));

        Character[] case2 = {'a', 'b', 'c', 'a'};
        List<Character> test2 = new ArrayList<>(Arrays.asList(case2));
        System.out.println(find(test2));

        Character[] case3 = {'a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a', 'd', 'e', 'f', 'e', 'g', 'd', 'e', 'h', 'i', 'j', 'h', 'k', 'l', 'i', 'j'};
        List<Character> test3 = new ArrayList<>(Arrays.asList(case3));
        System.out.println(find(test3));
    }
}
