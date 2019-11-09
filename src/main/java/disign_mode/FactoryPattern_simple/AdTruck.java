package disign_mode.FactoryPattern_simple;
//具体类
public class AdTruck implements Truck {
    @Override
    public void run() {
        System.out.println("奥迪车启动了！");
    }
}
