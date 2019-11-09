package prototypeModel;

import java.util.Arrays;

/**
 * @ProjectName: demo
 * @Package: prototypeModel
 * @ClassName: Resume
 * @Author: limingxing
 * @Description: TODO 简历原型，原型模式
 * @Date: 2019/7/12 18:13
 * @Version: 1.0
 */
public class Resume implements Cloneable {
    private String name; //姓名
    private int age; //年龄
    private String[] hobby;//爱好

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }

    //实现的是深克隆，对象的引用类型属性也会重新克隆一份，而不是直接引用原对象的内存地址
    @Override
    protected Resume clone() throws CloneNotSupportedException {
        //把原始对象克隆一份
        Resume clone = (Resume) super.clone();
        //获取对象里的引用对象，并进行克隆，获取克隆的引用对象
        String[] clone1 = clone.getHobby().clone();
        //把克隆的引用对象赋给克隆的对象
        clone.setHobby(clone1);
        //返回克隆的对象
        return clone;
    }
}
