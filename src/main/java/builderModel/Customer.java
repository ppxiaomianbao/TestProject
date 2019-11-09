package builderModel;

/**
 * @ProjectName: demo
 * @Package: builderModel
 * @ClassName: Customer
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/1 16:41
 * @Version: 1.0
 */
public class Customer {
    public static void main(String[] objects) {
        LenovoComputer lenovoComputer = new LenovoComputer();
        MiUiComputer miUiComputer = new MiUiComputer();
       /* Computer instance = ConcreteBuilder.getInstance(lenovoComputer);
        System.out.println("联想电脑： " + instance);


        Computer instance1 = ConcreteBuilder.getInstance(miUiComputer);
        System.out.println("小米电脑： " + instance1);*/

        new Thread(new Runnable(){

            @Override
            public void run() {
                Computer instance = ConcreteBuilder.getInstance(lenovoComputer);
                System.out.println("联想电脑： " + instance);
            }
        }).start();

        new Thread(new Runnable(){

            @Override
            public void run() {
                Computer instance1 = ConcreteBuilder.getInstance(miUiComputer);
                System.out.println("小米电脑： " + instance1);
            }
        }).start();
    }
}
