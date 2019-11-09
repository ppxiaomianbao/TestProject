package decoratorModel;

/**
 * @ProjectName: demo
 * @Package: decoratorModel
 * @ClassName: Test
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/15 18:42
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] objects) {
        Drink drink = new Beer();
        System.out.println("饮品的价格" + drink.price() + " 饮品的名称 " + drink.name());

        QingDaoBeer qingDaoBeer = new QingDaoBeer(drink);
        System.out.println("饮品的价格" + qingDaoBeer.price() + " 饮品的名称 " + qingDaoBeer.name());

    }
}
