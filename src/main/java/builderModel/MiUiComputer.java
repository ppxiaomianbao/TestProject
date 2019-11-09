package builderModel;

/**
 * @ProjectName: demo
 * @Package: builderModel
 * @ClassName: MiUiComputer
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/1 16:44
 * @Version: 1.0
 */
//小米电脑具体类
public class MiUiComputer implements Builder {
    private Computer computer = new Computer();
    @Override
    public void setCPU() {
        computer.setCpu("MiUiCPU");
    }

    @Override
    public void setMemory() {
        computer.setMemory("MiUi内存");
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("AMD显卡");
    }

    @Override
    public Computer getInstance() {
        return computer;
    }
}
