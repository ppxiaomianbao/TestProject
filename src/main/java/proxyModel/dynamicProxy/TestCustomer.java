package proxyModel.dynamicProxy;

import javafx.scene.AmbientLight;

/**
 * @ProjectName: demo
 * @Package: proxyModel.dynamicProxy
 * @ClassName: TestCustomer
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/31 16:10
 * @Version: 1.0
 */
// todo 测试代码
public class TestCustomer {

    public static void main(String[] objects) {
        Cat cat = new Cat();
        Object proxyInstance = ProxyUtil.getProxyInstance(cat);
        Animal animal = (Animal) proxyInstance;
        System.out.println(animal.getClass());
        animal.action();
        animal.breath();
        animal.action(5);
    }
}
