package builderModel;

import sun.reflect.generics.tree.VoidDescriptor;

/**
 * @ProjectName: demo
 * @Package: builderModel
 * @ClassName: Builder
 * @Author: limingxing
 * @Description: TODO 构建者模式抽象接口类，这种设计模式不能使用单例，会造成数据冲突
 * @Date: 2019/7/1 16:23
 * @Version: 1.0
 */

//构造零件接口
public interface Builder {

    //cpu
    public void setCPU();

    //内存
    public void setMemory();

    //显卡
    public void setDisplay();

    //获取构建的对象
    public Computer getInstance();
}
