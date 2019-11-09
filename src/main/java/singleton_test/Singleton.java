package singleton_test;

/**
 * @ProjectName: demo
 * @Package: singleton_test
 * @ClassName: Singleton
 * @Author: limingxing
 * @Description: TODO (饿汉式单例) 类加载的时候就初始化了，是线程安全的
 * @Date: 2019/6/29 9:55
 * @Version: 1.0
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance(){
        return singleton;
    }
}
