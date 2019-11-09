package MethodFactroy;
//具体实现
public class BamTruck implements Truck {
    @Override
    public void run() {
        System.out.println("宝马车启动！");
    }
}
