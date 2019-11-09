package disign_mode.FactoryPattern_simple;
//工厂的实现
public class Factroy {

    //调用此方法，通过判断来确定返回那个具体的类
    public static Truck purchaseTruck(String truck){
        if(truck.equals("奥迪")){
            return new AdTruck();
        }else if(truck.equals("宝马")){
            return new BamTruck();
        }else{
            throw new RuntimeException("无此车型！" + truck);
        }
    }
}
