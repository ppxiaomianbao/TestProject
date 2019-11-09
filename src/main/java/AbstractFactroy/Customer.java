package AbstractFactroy;
//测试类
public class Customer {
    public static void main(String[] objects) {
        Electronics electronics = new EelctronicsFactroy();
        electronics.getLenovo().getLenovoPhone().run();
        electronics.getLenovo().getLenovoDispayer().run();

        electronics.getMiUI().getMiUiDisplayer().run();
        electronics.getMiUI().getMiUiPhone().run();
        electronics.getMiUI().getMiUICharger().run();
    }
}
