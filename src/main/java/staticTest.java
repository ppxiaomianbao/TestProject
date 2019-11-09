/**
 * @ProjectName: demo
 * @Package: PACKAGE_NAME
 * @ClassName: staticTest
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/6/25 16:56
 * @Version: 1.0
 */
public class staticTest extends testStatic {

    static {
        System.out.println("my static");
    }

    public staticTest() {
        System.out.println("my customer");
    }

    public static void main(String[] objects) {
        new staticTest();
    }
}

class testStatic{
    public testStatic() {
        System.out.println("test customer");
    }
    private Person person = new Person();

    static {
        System.out.println("test static");
    }
}

class Person{
    static {
        System.out.println("person static");
    }
    public Person() {
        System.out.println("person customer");
    }
}
