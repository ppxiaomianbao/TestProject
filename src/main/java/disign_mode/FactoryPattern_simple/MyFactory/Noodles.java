package disign_mode.FactoryPattern_simple.MyFactory;

public class Noodles implements Meal {

    @Override
    public void order() {
        System.out.println("面条正在准备中！");
    }
}
