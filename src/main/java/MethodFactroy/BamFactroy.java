package MethodFactroy;
//工厂实现
public class BamFactroy implements TruckFactroy {
    @Override
    public Truck getProducttion() {
        return new BamTruck();
    }
}
