package LC;

import java.util.LinkedList;
import java.util.Queue;

public class LC0225_Implement_Stack_using_Queues {
    class MyStack {
        Queue<Integer> queueIn;
        Queue<Integer> queueOut;
        int size;

        /** Initialize your data structure here. */
        public MyStack() {
            queueIn = new LinkedList<>();
            queueOut = new LinkedList<>();
            size = 0;
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queueIn.offer(x);
            size++;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (size == 0) {
                throw new IllegalArgumentException("No element");
            }
            for (int i = 0; i < size - 1; i++) {
                queueOut.offer(queueIn.poll());
            }
            int result = queueIn.poll();
            while (!queueOut.isEmpty()) {
                queueIn.offer(queueOut.poll());
            }
            size--;
            return result;
        }
        int max = Integer.MAX_VALUE

        /** Get the top element. */
        public int top() {
            if (size == 0) {
                throw new IllegalArgumentException("No element");
            }
            for (int i = 0; i < size - 1; i++) {
                queueOut.offer(queueIn.poll());
            }
            int result = queueIn.peek();
            queueOut.offer(queueIn.poll());
            while (!queueOut.isEmpty()) {
                queueIn.offer(queueOut.poll());
            }
            return result;

        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queueIn.isEmpty();

        }
    }
}
