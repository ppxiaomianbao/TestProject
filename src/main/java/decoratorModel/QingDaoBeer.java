package decoratorModel;

/**
 * @ProjectName: demo
 * @Package: decoratorModel
 * @ClassName: QiingDaoBeer
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/15 18:46
 * @Version: 1.0
 */
public class QingDaoBeer extends Decorator {

    public QingDaoBeer(Drink drink) {
        super(drink);
    }

    @Override
    public double price() {
        return drink.price() + 2;
    }

    @Override
    public String name() {
        return "青岛" + drink.name();
    }
}
