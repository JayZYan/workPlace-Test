package LC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class Thread implements Runnable {
    public Thread() {

    }
    @Override
    public void run() {
        System.out.println("aaaa");
    }
    public void start() {
        run();
    }
    public static void main(String[] args) {
//        Thread th = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("bbbb");
//            }
//        };
//        for (int i = 0; i < 100; i++) {
//            th.start();
//            System.out.println("cccc");
//        }
        String s = "abc";
        System.out.println(s.substring(1,2));
        char[] arr = {'a','b','c'};
        System.out.println(new String(arr, 1, 2));
        HashMap;

        int[] arr123 = {1,2,3};
        Arrays.asList(arr123);



    }
}
