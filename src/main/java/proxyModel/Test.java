package proxyModel;

import java.lang.reflect.Proxy;

/**
 * @ProjectName: demo
 * @Package: proxyModel
 * @ClassName: Test
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/16 21:56
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] objects) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.getCar();
    }
}
