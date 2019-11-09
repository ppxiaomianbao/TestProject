package adapter.Object_adapter;

/**
 * @ProjectName: demo
 * @Package: adapter.Object_adapter
 * @ClassName: Test
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/15 18:10
 * @Version: 1.0
 */
public class Test {


    public static void main(String[] objects) {
        PowerAdapter powerAdapter = new PowerAdapter();
        int dianya = powerAdapter.dianya();
        System.out.println(dianya);
    }
}
