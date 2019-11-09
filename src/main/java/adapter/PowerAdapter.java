package adapter;

/**
 * @ProjectName: demo
 * @Package: adapter
 * @ClassName: PowerAdapter
 * @Author: limingxing
 * @Description:  TODO 类适配器，直接用super调用父类的方法，然后处理，得到想要的结果
 *          TODO  ！！！！！！！！！！！！适配器一般用于已经写好，并在运行中的接口，他需要根据原接口的结果，然后在把结果处理成我们更改后的结果进行返回
 * @Date: 2019/7/15 18:06
 * @Version: 1.0
 */
public class PowerAdapter extends DC220 implements DC5 {

    @Override
    public int dianya() {
        return super.voltoge() / 44;
    }
}
