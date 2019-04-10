package LC;

import java.util.ArrayList;
import java.util.List;

public class StringParse {
    public List<String> parse(String str) {
        int len = str.length();
        char escape = ' ';
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '\'') {
                escape = escape == '\'' ? ' ' : '\'';
                if (sb.length() != 0) {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            else if (str.charAt(i) == escape) {
                if (sb.length() != 0) {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(str.charAt(i));
            }
        }
        if (sb.length() != 0) {
            res.add(sb.toString());
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "' a ' ah  This' is  ' Apple' a ";
        StringParse test = new StringParse();
        System.out.println(test.parse(str));
    }



}
