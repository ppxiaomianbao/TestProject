package proxyModel.dynamicProxy1;


import com.example.demo.ClassLoaderTest.ABSclass;
import com.sun.org.apache.xpath.internal.Arg;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ProjectName: demo
 * @Package: proxyModel.dynamicProxy1
 * @ClassName: MyProxy
 * @Author: limingxing
 * @Description: todo 这种动态代理方式不需要目标对象实现接口，更灵活Cglib代理,也叫作子类
 * @Date: 2019/7/31 16:58
 * @Version: 1.0
 */

// todo 实现代理的类
public class MyProxy implements MethodInterceptor {
    private Object target;

    public MyProxy(Object target){
        this.target = target;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("==================代理类开始执行 方法名 " + method.getName() + " 参数个数 " + (objects==null?0:objects.length) + " 参数：" + Arrays.toString(objects) + target.getClass());
        Object result = method.invoke(target,objects);
        System.out.println("==================代理类执行结束 方法名 " + method.getName() + " 参数个数 " + (objects==null?0:objects.length) + " 参数：" + Arrays.toString(objects) + target.getClass().getCanonicalName());
        return result;
    }

    public Object getProxyInstance(){
        //工具类
        Enhancer en = new Enhancer();

        //设置父类
        en.setSuperclass(target.getClass());

        //设置回调函数
        en.setCallback(this);

        //创建子类
        return en.create();
    }
}
