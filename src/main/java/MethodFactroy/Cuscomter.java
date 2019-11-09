package MethodFactroy;
//测试类
public class Cuscomter {
    public static void main(String[] objects) {
        Truck aod = new AodTruck();
        aod.run();

        Truck bam = new BamTruck();
        bam.run();

        Truck daz = new DazTruck();
        daz.run();
    }
}
