package proxyModel.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @ProjectName: demo
 * @Package: proxyModel.dynamicProxy
 * @ClassName: ProxyUtil
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/7/31 16:07
 * @Version: 1.0
 */

// todo 代理类的工具类，方便操作
public class ProxyUtil {

    public static Object getProxyInstance(Object target){
        MyProxy proxy = new MyProxy(target);

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),proxy);
    }
}
