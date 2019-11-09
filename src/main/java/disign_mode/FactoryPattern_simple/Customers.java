package disign_mode.FactoryPattern_simple;

//测试类
public class Customers {
    public static void main(String[] objects) {
        Factroy.purchaseTruck("宝马").run();
        Factroy.purchaseTruck("奥迪").run();
        Factroy.purchaseTruck("大众").run();
    }
}
