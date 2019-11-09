package proxyModel.dynamicProxy1;

/**
 * @ProjectName: demo
 * @Package: proxyModel.dynamicProxy1
 * @ClassName: Test
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/31 17:05
 * @Version: 1.0
 */

// todo 测试类
public class Test {

    public static void main(String[] objects) {
        Cat cat = new Cat();
        MyProxy myProxy = new MyProxy(cat);
        Cat proxyInstance = (Cat) myProxy.getProxyInstance();
        proxyInstance.action(6);
    }
}
