package interview;


import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxMain {
    public static void main(String[] args) {
        ProxyInterface proxyInterface =(ProxyInterface) Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(),
                new Class[]{ProxyInterface.class}, (proxy, method, args1) -> {
                    if (method.getName().equals("test")) {
                        System.out.println("代理方法代替执行了" + Arrays.toString(args1));
                    }
                    return null;
                });
         proxyInterface.test("执行");
    }


}
