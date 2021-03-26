package zzx.java.base.agent.dynamicAgent.agentOnJdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        BusinessInterfaceImpl impl = new BusinessInterfaceImpl();
        InvocationHandler handler = new ProxyClass(impl);
        BusinessInterface proxyInstance = (BusinessInterface)Proxy.
                newProxyInstance(handler.getClass().getClassLoader(), impl.getClass().getInterfaces(), handler);
        proxyInstance.printSomeThing("print");
        String returnResult = proxyInstance.returnSomeThing("return");
        System.out.println(returnResult);
    }

}
