package proxyModel;

/**
 * @ProjectName: demo
 * @Package: proxyModel
 * @ClassName: ProxyFactory
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/16 21:55
 * @Version: 1.0
 */
public class ProxyFactory implements Car {
    @Override
    public void getCar() {
        new AodCar().getCar();
    }
}
