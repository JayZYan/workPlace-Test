package LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommentExtractor {
    //Powered by Java Y
    enum BlockStatus {
        Initial, Processing, Done;
    }
    static class BlockFlag {
        BlockStatus status;
        BlockFlag() {
            status = BlockStatus.Initial;
        }
    }

    private static String parseCode(String string) {

        String[] source = string.split("\n");

        StringBuilder sb = new StringBuilder();
        BlockFlag block = new BlockFlag();
        for (String line : source) {
            char[] chars = line.toCharArray();
            boolean comment = false;

            for (int i = 0; i < chars.length; i++) {

                if (block.status == BlockStatus.Processing || comment) {
                    sb.append(chars[i]);
                }
                else if (i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '/') {
                    comment = true;
                    i++;    //skip second '/'
                }
                else if (i + 1 < line.length() && chars[i] == '/' && chars[i + 1] == '*') {
                    block.status = BlockStatus.Processing;
                    i++;    //skip '*'
                }
                else if (i + 1 < line.length() && chars[i] == '*' && chars[i + 1] == '/') {
                    block.status = BlockStatus.Done;
                    i++;
                }
            }
            if (comment || block.status == BlockStatus.Done) {
                sb.append("##");
            }
            else if (block.status == BlockStatus.Processing) {
                //sb.setLength(sb.length() - 2);
                sb.append('#');
            }
        }

        return sb.toString().replaceAll("#", "\n");
    }

    // Driver Method
    public static void main(String[] args) {
        String input = "import java.math.*;\n" +
                "import java.util.regex.*;\n" +
                "// comment\n" +
                "\n" +
                "public class Solution {\n" +
                "    int x; // trailing comment\n" +
                "    public static void main(String args[] ) throws Exception {\n" +
                "        /* Enter your code here. Read input from STDIN. Print output to STDOUT */\n" +
                "        /* multiple\n" +
                "        line\n" +
                "        1\n" +
                "        2\n" +
                "        */\n" +
                "    }\n";

        System.out.println(parseCode(input));

    }
}
