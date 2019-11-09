package decoratorModel;

/**
 * @ProjectName: demo
 * @Package: decoratorModel
 * @ClassName: Beer
 * @Author: limingxing
 * @Description: TODO 啤酒具体类
 * @Date: 2019/7/15 18:41
 * @Version: 1.0
 */
public class Beer implements Drink {
    @Override
    public double price() {
        return 2.00;
    }

    @Override
    public String name() {
        return "啤酒";
    }
}
