package threadTest;

/**
 * @ProjectName: demo
 * @Package: threadTest
 * @ClassName: threadDemo
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/23 16:28
 * @Version: 1.0
 */
public class threadDemo implements Runnable {
    private Object obj = new Object();
    private boolean flag;

    public threadDemo(boolean flag){
        this.flag = flag;
    }
    @Override
    public void run() {
        if(flag){
            synchronized (obj){
                System.out.println(Thread.currentThread().getName() + "if******" + "true");
                synchronized (this){
                    System.out.println(Thread.currentThread().getName() + "if******" + "true");
                }
            }
        }else{
            synchronized (this){
                System.out.println(Thread.currentThread().getName() + "else******" + "false");
                synchronized (obj){
                    System.out.println(Thread.currentThread().getName() + "else******" + "false");
                }
            }
        }
    }
}
