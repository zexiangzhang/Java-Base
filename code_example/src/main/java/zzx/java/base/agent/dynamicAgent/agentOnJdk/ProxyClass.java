package zzx.java.base.agent.dynamicAgent.agentOnJdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

public class ProxyClass implements InvocationHandler {

    private BusinessInterfaceImpl impl;

    public ProxyClass(BusinessInterfaceImpl impl) {
        this.impl = impl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("被代理对象之前执行了");
        Object invoke = method.invoke(impl, args);
        if (Objects.nonNull(invoke)) {
            System.out.println("这是被代理对象的返回结果： " + invoke);
            invoke = invoke + "  被改变了";
        }
        System.out.println("被代理对象之后执行了");
        return invoke;
    }
}
