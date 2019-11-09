package disign_mode.FactoryPattern_simple.MyFactory;

//用餐的客人
public class Guest {
    public static void main(String[] objects) {
        DiningRoom.getOrder("面条").order();
        DiningRoom.getOrder("牛肉饭").order();
        DiningRoom.getOrder("牛肉面").order();
    }
}
