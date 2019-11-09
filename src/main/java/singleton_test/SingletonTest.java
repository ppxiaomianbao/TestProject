package singleton_test;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: singleton_test
 * @ClassName: SingletonTest
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/6/29 9:57
 * @Version: 1.0
 */
public class SingletonTest {
    public static void main(String[] objects) {
        /*System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());*/

        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    System.out.println(Singleton2.getInstance());
                }
            }.start();

        }
    }
}
