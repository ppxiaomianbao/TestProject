package comparable_and_compartor;

import java.util.*;

/**
 * @ProjectName: demo
 * @Package: comparable_and_compartor
 * @ClassName: ComparableTest
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/8/13 15:43
 * @Version: 1.0
 */
public class ComparableTest implements Comparable<ComparableTest> {
    private String name;
    private int    age;

    public ComparableTest(String name, int age) {
        this.name = name;
        this.age = age;
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
    public int compareTo(ComparableTest o) {
        if(o.getAge()>this.getAge()){
            return 1;
        }else if(o.getAge()<this.getAge()){
            return -1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        List<ComparableTest> list = new ArrayList();
        ComparableTest c1 = new ComparableTest("limx",22);
        ComparableTest c2 = new ComparableTest("zhanggr",21);
        ComparableTest c3 = new ComparableTest("chnegtf",23);
        ComparableTest c4 = new ComparableTest("zhanggr",22);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        Collections.sort(list, new Comparator<ComparableTest>() {
            @Override
            public int compare(ComparableTest o1, ComparableTest o2) {
                if(o1.getAge()>o2.getAge()){
                    return -1;
                }else if(o1.getAge()<o2.getAge()){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        System.out.println(list);
        Collections.sort(list);
        System.err.println(list);
    }


    @Override
    public String toString() {
        return "ComparableTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
