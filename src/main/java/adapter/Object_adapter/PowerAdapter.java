package adapter.Object_adapter;

/**
 * @ProjectName: demo
 * @Package: adapter.Object_adapter
 * @ClassName: PowerAdapter
 * @Author: limingxing
 * @Description: TODO 对象适配器，在适配器里创建类的对象，用对象调用方法，然后进行处理，得到想要的结果
 * @Date: 2019/7/15 18:09
 * @Version: 1.0
 */
public class PowerAdapter implements DC5 {
    private DC220 dc220 = new DC220();
    @Override
    public int dianya() {
        int voltoge = dc220.voltoge();
        return voltoge / 44;
    }
}
