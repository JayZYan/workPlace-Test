package LC;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyMathTest {
    MyMath myMath = new MyMath();

    @BeforeEach
    public void before() {
        System.out.println("Before");

    }
    @AfterEach
    public void after() {
        System.out.println("after");

    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");

    }
    @AfterClass
    public static void afterClass() {
        System.out.println("afterclass");

    }

    @Test
    void sum_with3numbers() {
        System.out.println("test1");
        assertEquals(6, myMath.sum(new int[]{1,2,3}));
    }
    @Test
    void sum_with1numbers() {
        System.out.println("test2");
        assertEquals(1, myMath.sum(new int[]{1}));
    }
}