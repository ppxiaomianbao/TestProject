package singleton_test;

/**
 * @ProjectName: demo
 * @Package: singleton_test
 * @ClassName: Singleton2
 * @Author: limingxing
 * @Description: TODO 静态内部类方式设计单例模式
 * @Date: 2019/6/29 10:42
 * @Version: 1.0
 */
public class Singleton2 {

    private Singleton2(){

    }

    private static class Singleton{
        private static Singleton2 singleton2 = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return Singleton.singleton2;
    }
}
