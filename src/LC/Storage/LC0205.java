package LC;

import java.util.HashMap;

public class LC0205 {
    private static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (!mapS.containsKey(charS)) {
                mapS.put(charS, charT);
                if (mapT.containsKey(charT)) {
                    return false;
                } else {
                    mapT.put(charT, charS);
                }
            } else {
                if ( !mapT.containsKey(charT) || mapT.get(charT) != charS) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";

        System.out.println(isIsomorphic(s, t));
    }
}
