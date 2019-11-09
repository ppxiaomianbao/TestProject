package TEST;

/**
 * @ProjectName: demo
 * @Package: TEST
 * @ClassName: TestTest
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/8/8 10:50
 * @Version: 1.0
 */
public class TestTest {

    public static void main(String[] args) {
        System.out.println(ggg());
    }

    private static int ggg() {
        try {
            return 3/0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return 5;
        }
    }
}
