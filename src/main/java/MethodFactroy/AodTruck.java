package MethodFactroy;
//具体实现
public class AodTruck implements Truck {
    @Override
    public void run() {
        System.out.println("奥迪车启动！");
    }
}
