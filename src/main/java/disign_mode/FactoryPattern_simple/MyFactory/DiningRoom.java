package disign_mode.FactoryPattern_simple.MyFactory;

//餐厅类
public class DiningRoom {

    public static Meal getOrder(String name){
        switch (name){
            case "面条":
                return new Noodles();
            case "牛肉饭":
                return new BeefMeal();
            default:
                throw new RuntimeException("没有此餐品！ " + name);
        }

    }
}
