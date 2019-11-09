package threadTest;

/**
 * @ProjectName: demo
 * @Package: threadTest
 * @ClassName: Test
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/23 16:27
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] objects) {
        threadDemo d1 = new threadDemo(true);
        threadDemo d2 = new threadDemo(false);
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t2.start();
        t1.start();
    }
}
