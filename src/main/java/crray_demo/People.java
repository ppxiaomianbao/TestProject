package crray_demo;

import java.util.Date;

/**
 * @ProjectName: demo
 * @Package: crray_demo
 * @ClassName: People
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/18 17:00
 * @Version: 1.0
 */
public class People {
    private String name;
    private int age;
    private Date brithDay;
    private String hobby;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", brithDay=" + brithDay +
                ", hobby='" + hobby + '\'' +
                '}';
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

    public Date getBrithDay() {
        return brithDay;
    }

    public void setBrithDay(Date brithDay) {
        this.brithDay = brithDay;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
