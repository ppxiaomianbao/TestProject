package proxyModel.dynamicProxy;

/**
 * @ProjectName: demo
 * @Package: proxyModel.dynamicProxy
 * @ClassName: Dog
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/31 16:02
 * @Version: 1.0
 */
public class Dog implements Animal {
    @Override
    public void action() {
        System.out.println("汪汪汪~~~");
    }

    @Override
    public void action(int a) {

    }

    @Override
    public void breath() {
        System.out.println("狗式呼吸法~~~");
    }
}
