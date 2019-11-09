package adapter;

/**
 * @ProjectName: demo
 * @Package: adapter
 * @ClassName: Test
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/15 18:07
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] objects) {
        PowerAdapter dc5 = new PowerAdapter();
        int dianya = dc5.dianya();
        System.out.println(dianya);
    }

}
