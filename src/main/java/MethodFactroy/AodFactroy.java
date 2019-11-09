package MethodFactroy;
//工厂实现
public class AodFactroy implements TruckFactroy {
    @Override
    public Truck getProducttion() {
        return new AodTruck();
    }
}
