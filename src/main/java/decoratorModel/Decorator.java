package decoratorModel;

/**
 * @ProjectName: demo
 * @Package: decoratorModel
 * @ClassName: Decorator
 * @Author: limingxing
 * @Description: TODO 装饰器类，如果有些方法是不需要的，就可以申明为抽象类,这种模式符合开闭原则，把原对象作为参数创建新增饮品类
 *               TODO ，然后在新增饮品类里调用原来的方法，修改之后再返回，以达到创建不同的饮品
 *
 *               TODO 如果饮品下有多个不同种类，此类也不需要更改，容易扩展
 *
 *               TODO 优点：可以直接对需要类的功能进行增强或者扩展。
 *                缺点：这种方法的完成需要使用继承才能完成，会使得整个体系过于臃肿。
 * @Date: 2019/7/15 18:44
 * @Version: 1.0
 */
public abstract class  Decorator implements Drink {

    public Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double price() {
        return drink.price();
    }

    @Override
    public String name() {
        return drink.name();
    }
}
