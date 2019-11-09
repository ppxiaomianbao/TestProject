package singleton_test;

/**
 * @ProjectName: demo
 * @Package: singleton_test
 * @ClassName: Singleton1
 * @Author: limingxing
 * @Description: TODO （懒汉式单例）类加载时不没有实例化，等到调用的时候才创建实例，因为加了synchronized代码块，并且在songleton1对象上加上了volatile关键字，保证了在并发下也是线程安全的
 * // TODO 编译优化，步骤1.分配内存，2.创建对象，3.把对象内存地址赋值给变量引用，如果按照顺序来走就没有问题，但是在jvm会做编译优化，可能会改变执行步骤，改为 1,3,2，这样就可能产生问题
 * TODO 第一个线程刚好执行编译优化后的2步骤，第二个线程调用了getInstance方法，第一个判断就不为空，直接返回songleton1对象，如果这是调用对象的变量就可能会出现nullpointexception异常，
 * TODO 加上volatile关键字保证不会出现这种情况
 * @Date: 2019/6/29 10:10
 * @Version: 1.0
 */
public class Singleton1 {
    private volatile static Singleton1 singleton1 = null;

    private Singleton1() {
    }

    public static Singleton1 getInstance(){
        if(singleton1 == null){
            // TODO Singleton1.class是锁住整个类，如果用singleton1就是锁住此对象
            synchronized (Singleton1.class){
                if(singleton1 == null){
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
