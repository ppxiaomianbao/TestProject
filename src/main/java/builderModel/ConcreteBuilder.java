package builderModel;

/**
 * @ProjectName: demo
 * @Package: builderModel
 * @ClassName: ConcreteBuilder
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/1 16:28
 * @Version: 1.0
 */
//构造者类
public class ConcreteBuilder {

    //需传入具体的电脑类
    public static Computer getInstance(Builder builder){
        //构建每个部件
        builder.setMemory();
        builder.setDisplay();
        builder.setCPU();
        //获取构建的对象
        Computer instance = builder.getInstance();

        //返回构建的对象
        return instance;
    }
}
