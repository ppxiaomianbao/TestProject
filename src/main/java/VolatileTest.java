import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: demo
 * @Package: PACKAGE_NAME
 * @ClassName: VolatileTest
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/6/26 10:47
 * @Version: 1.0
 */
public class VolatileTest {
    //并发编程一定要用concurrentHashMap
    public static Map<Integer,Integer> map = new ConcurrentHashMap<>(100000);
    //元子类操作
    private static AtomicInteger num = new AtomicInteger(0);
    //private volatile static int num = 0;

    public static void main(String[] objects) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[10];
        for(int i=0;i<threads.length; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<10000; j++){
                        createInt();
                    }
                }
            });
            threads[i].start();
        }
        for(Thread thread : threads){
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("num:" + num + "time:" + (end-start));
        System.out.println(map.get(1) + "  " + map.size());

        //testVolatile();
    }

    public static void createInt(){
        VolatileTest b = new VolatileTest();
        //两种方法都是在当前基础上加一，但是一个是加之前的值（getAndIncrement），一个是返回加之后的值（incrementAndGet）
        int i = num.incrementAndGet();
        //int i = num.getAndIncrement();
        map.put(i,i);
    }

    /**
     * @Method testVolatile
     * @Author limingxing
     * @Version  1.0
     * @Description TODO 测试Volatile关键字的可见性
     * @param
     * @Return void
     * @Exception
     * @Date 2019/6/26 14:02
     */
    private volatile static int y=0,x=0;
    private static Map<Integer,Integer> map1 = new ConcurrentHashMap<>(10000);
    private static Set<String> set =new HashSet<>();
    public static void testVolatile() throws InterruptedException {
        Map<String,Integer> resultMap = new HashMap<>();
        for(int i=0; i<5000000;i++){
            x=0;
            y=0;
            resultMap.clear();
            Thread thread1 = new Thread(new Runnable() {
                public void run() {
                    int a = x;
                    y = 1;
                    resultMap.put("a",a);
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                public void run() {
                    int b = y;
                    x = 1;
                    resultMap.put("b",b);
                }
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            set.add("a=" + resultMap.get("a")+ "," + "b=" +resultMap.get("b"));
            System.out.println(set + "    " + set.size() + "      " + i);
        }
    }
}
