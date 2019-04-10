package LC.LCPkg;

import java.util.Arrays;

/*  Author: Java Yan
    Date: 1.27.2019
 */
public class ListNodeGenerator {

    public static String serialize(ListNode headOriginal){
        if (headOriginal == null) {
            return "Input not valid";
        }
        ListNode head = headOriginal;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return sb.toString();
    }
    public static ListNode deserialize(int[] data){
        if (data == null || data.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(data[0]);
        ListNode cur = dummy;
        for (int i = 1; i < data.length; i++) {
                cur.next = new ListNode(data[i]);
                cur = cur.next;
        }
        return dummy;
    }

}
