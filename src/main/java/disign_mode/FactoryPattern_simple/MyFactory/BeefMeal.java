package disign_mode.FactoryPattern_simple.MyFactory;

//牛肉饭
public class BeefMeal implements Meal {
    @Override
    public void order() {
        System.out.println("牛肉饭正在准备中！");
    }
}
