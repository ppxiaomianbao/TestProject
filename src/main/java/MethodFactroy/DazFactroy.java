package MethodFactroy;

public class DazFactroy implements TruckFactroy {
    @Override
    public Truck getProducttion() {
        return new DazTruck();
    }
}
