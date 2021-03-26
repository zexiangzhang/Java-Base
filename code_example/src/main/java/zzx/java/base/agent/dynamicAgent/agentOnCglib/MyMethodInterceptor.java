package zzx.java.base.agent.dynamicAgent.agentOnCglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("==========前置业务==========");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("==========后置业务==========");
        return obj;
    }
}
