package builderModel;

import com.sun.istack.internal.FinalArrayList;

/**
 * @ProjectName: demo
 * @Package: builderModel
 * @ClassName: Computer
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/1 16:34
 * @Version: 1.0
 */
//电脑实体
public class Computer {
    private volatile static Computer computer;
    private String cpu;
    private String display;
    private String memory;

    /*private Computer(){}

    public static Computer getInstance(){
        if(computer == null){
            synchronized (Computer.class){
                if(computer == null){
                    computer = new Computer();
                }
            }
        }
        return computer;
    }*/

    public Computer() { }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", display='" + display + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }
}
