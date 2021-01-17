package cn.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author JacksonTom
 * @date 2021-01-15
 * @function
 */
public class ProxyTest {
    public static void main(String[] args) {
        //真实对象
        Lenovo lenovo = new Lenovo();

        //代理对象
        /*参数
        * 1.类加载器：真实对象
        * 2.接口数组：真实对象
        * 3.处理器：new InvocationHandler()
        * */
        SellComputer proxy_lenovo = (SellComputer)Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            //代理逻辑编写的代码：代理对象调用的所有方法都会触发该方法
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理逻辑");
                System.out.println(method.getName());
                System.out.println(args[0]);
                return null;
            }
        });

        //调用方法
        String computer = proxy_lenovo.sell(8000);
        System.out.println(computer);

    }

}
