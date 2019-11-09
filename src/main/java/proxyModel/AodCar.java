package proxyModel;

/**
 * @ProjectName: demo
 * @Package: proxyModel
 * @ClassName: CarFactory
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/16 21:50
 * @Version: 1.0
 */
public class AodCar implements Car {
    @Override
    public void getCar() {
        System.out.println("奥迪车");
    }
}
