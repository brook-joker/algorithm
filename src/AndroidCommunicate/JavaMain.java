package AndroidCommunicate;

import leetcode.Leet590;
import leetcode.TreeNode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaMain {

    static interface A {
        Object getItem(String str);
    }

    static interface B extends A {
        String getItem(String str);
    }

    static class AA implements A{

        @Override
        public Object getItem(String str) {
            System.out.println(str);
            return str;
        }
    }


     class Imp implements InvocationHandler{

        private A a;

        public Imp(A a) {
            this.a = a;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("---before----");
            Object result = method.invoke(a,args);
            System.out.println("---end----");
            return result;
        }
    }


//    static Object createInstance(Class<?> clazz) {
//        //return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, stubHandler);
//    }


    public static void main(String[] args) {
//        A a = (A) createInstance(B.class);
//        B b = (B) createInstance(B.class);
//
//        b.getItem("A-A-B");
//        // Crash
//        a.getItem("B-B-B");

       // Imp imp = new Imp(new AA());


    }

}
