package LC;

import LC.LCPkg.ListNode;
import LC.LCPkg.ListNodeGenerator;

import java.util.*;

public class LC0023_Merge_k_Sorted_Lists {
    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int k = lists.length;

        Queue<ListNode> minHeap = new PriorityQueue<>(k, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode nodes : lists) {
            if (nodes != null) {
                minHeap.offer(nodes);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {

            ListNode curHead = minHeap.poll();

            cur.next = curHead;
            cur = cur.next;
            if (curHead.next != null) {
                minHeap.offer(curHead.next);
            }

        }
        cur.next = null;
        return dummy.next;
    }
    public static void main(String[] args) {
        int[][] data = {{1,4,5},{1,3,4},{2,6}};
        int size = data.length;
        ListNode[] list = new ListNode[size];
        for (int i = 0; i < size; i++) {
            list[i] = ListNodeGenerator.deserialize(data[i]);
            //System.out.println(ListNodeGenerator.serialize(list[i]));
        }
        ListNode result = mergeKLists(list);
        System.out.println(ListNodeGenerator.serialize(result));

    }
}
