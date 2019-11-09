package disign_mode.FactoryPattern_simple;
//具体类
public class BamTruck implements Truck {
    @Override
    public void run() {
        System.out.println("宝马车启动了！");
    }
}
