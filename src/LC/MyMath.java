package LC;

import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

public class MyMath {
    int sum(int[] numbers) {

        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }

    public void test() throws InterruptedException{
        String[] str = new String[5];
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(UUID.randomUUID().toString());
            }
        });
        while (true) {
            thread.run();
            Thread.sleep(1000);
        }


    }


    public static void main(String[] args) throws Exception{
        MyMath test = new MyMath();
        test.test();

    }
}
