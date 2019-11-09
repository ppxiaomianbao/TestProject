package crray_demo;

import java.util.Date;

/**
 * @ProjectName: demo
 * @Package: crray_demo
 * @ClassName: Test
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/18 17:01
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] objects) {
        People people = new People();
        people.setAge(18);
        people.setBrithDay(new Date(1997,12,20));
        people.setHobby("打地下城与勇士");
        People people1 = new People();
        people1.setAge(20);
        people1.setHobby("听歌");
        people1.setBrithDay(new Date(2019,07,18));
        people1.setName("李明星");
        People t = people;
        System.out.println(people.equals(t));
        System.err.println(people);
        System.err.println(people1);
        //TODO 此测试证明java中只有值传递，不存在引用传递，只不过引用类型的值传递是可以改变对象的属性的，对象的引用是无法改变的
        swap(people,people1);
        System.err.println(people);
        System.err.println(people1);
        /*System.err.println("e1" + people);
        testObject(people);
        System.err.println("e2" + people);*/

    }

    public static void testObject(People people){
        System.out.println("m1" + people);
        people.setAge(20);
        people.setHobby("听歌");
        people.setBrithDay(new Date(2019,07,18));
        people.setName("李明星");
        System.out.println("m2" + people);
    }

    public static void swap (People x,People y){
        People t = x;
        t.setAge(100);
        x = y;
        y = t;
        System.out.println(x);
        System.out.println(y);
    }
}
