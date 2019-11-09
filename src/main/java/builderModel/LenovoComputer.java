package builderModel;

import java.awt.*;

/**
 * @ProjectName: demo
 * @Package: builderModel
 * @ClassName: Computer
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/1 16:32
 * @Version: 1.0
 */
//联想电脑具体类
public class LenovoComputer implements Builder {
    private Computer computer = new Computer();

    @Override
    public void setCPU() {
        computer.setCpu("intel");
    }

    @Override
    public void setMemory() {
        computer.setMemory("三星");
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("七彩虹");
    }

    @Override
    public Computer getInstance() {
        return computer;
    }
}
