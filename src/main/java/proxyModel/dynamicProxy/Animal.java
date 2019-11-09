package proxyModel.dynamicProxy;

/**
 * @ProjectName: demo
 * @Package: proxyModel.dynamicProxy
 * @ClassName: Animal
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/31 16:00
 * @Version: 1.0
 */

// todo 目标对象所实现的接口
public interface Animal {

    public void action();

    public void action(int a);

    public void breath();
}
