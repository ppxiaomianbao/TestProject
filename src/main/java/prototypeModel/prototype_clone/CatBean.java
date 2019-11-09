package prototypeModel.prototype_clone;

import java.io.*;
import java.util.Date;

/**
 * @ProjectName: demo
 * @Package: prototypeModel.prototype_clone
 * @ClassName: CatBean
 * @Author: limingxing
 * @Description:  TODO 车信息，里面包含一个持有人信息
 * @Date: 2019/7/13 9:49
 * @Version: 1.0
 */
public class CatBean implements Cloneable,Serializable {
    private String name;
    private Date date;
    private Holder holder;

    public CatBean(){
        this.date = new Date();
        this.name = "汽车";
        this.holder = new Holder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    @Override
    protected CatBean clone() throws CloneNotSupportedException {
        CatBean catBean = (CatBean) super.clone();
        catBean.setHolder(catBean.getHolder().clone());
        return catBean;
    }

    protected CatBean deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        CatBean o = (CatBean) ois.readObject();
        return o;
    }

    @Override
    public String toString() {
        return "CatBean{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", holder=" + holder +
                '}';
    }
}

class Holder implements Cloneable,Serializable{
    private String name;
    private int age;

    public Holder(){
        this.name = "李明星";
        this.age = 23;
    }

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

    @Override
    protected Holder clone() throws CloneNotSupportedException {
        Holder holder = (Holder) super.clone();
        return holder;
    }

    @Override
    public String toString() {
        return "Holder{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
