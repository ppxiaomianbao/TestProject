package proxyModel.dynamicProxy;

import sun.management.Agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ProjectName: demo
 * @Package: proxyModel.dynamicProxy
 * @ClassName: MyProxy
 * @Author: limingxing
 * @Description:todo 这种动态代理需要目标对象实现接口JDK动态代理
 * @Date: 2019/7/31 16:04
 * @Version: 1.0
 */
// todo 实现代理的类
public class MyProxy implements InvocationHandler {
    private Object target;

    public MyProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
            System.out.println("==================代理类开始执行 方法名 " + method.getName() + " 参数个数 " + (objects==null?0:objects.length) + " 参数：" + Arrays.toString(objects) + target.getClass());
            Object result = method.invoke(target,objects);
            System.out.println("==================代理类执行结束 方法名 " + method.getName() + " 参数个数 " + (objects==null?0:objects.length) + " 参数：" + Arrays.toString(objects) + target.getClass().getCanonicalName());
            return result;
    }
}
