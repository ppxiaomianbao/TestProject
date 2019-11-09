package proxyModel.dynamicProxy;

/**
 * @ProjectName: demo
 * @Package: proxyModel.dynamicProxy
 * @ClassName: Cat
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/31 16:01
 * @Version: 1.0
 */

// todo 目标对象
public class Cat implements Animal {
    @Override
    public void action() {
        System.out.println("喵喵喵~~~");
    }

    public void action(int a) {
        System.out.println("喵喵喵~~~" + " 重载方法");
    }

    @Override
    public void breath() {
        System.out.println("猫式呼吸法~~~");
    }
}
