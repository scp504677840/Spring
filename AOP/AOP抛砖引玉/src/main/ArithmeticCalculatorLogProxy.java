package main;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ArithmeticCalculatorLogProxy {

    /**
     * 代理对象
     */
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLogProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getLogProxy() {
        ArithmeticCalculator proxy = null;

        //代理对象由哪一个类加载器负责加载
        ClassLoader classLoader = target.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class[] interfaces = new Class[]{ArithmeticCalculator.class};
        //当调用代理对象其中的方法时，执行该代码
        InvocationHandler h = new InvocationHandler() {
            /**
             * 调用代理对象方法时触发
             * @param proxy 正在返回的代理对象
             * @param method 正在被调用的方法
             * @param args 调用方法时，传入的参数
             * @return 执行结果
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理方法执行前。。。");
                Object result = method.invoke(target, args);
                System.out.println("代理方法执行后。。。");
                return result;
            }
        };
        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(classLoader, interfaces, h);
        return proxy;
    }

}
