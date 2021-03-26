package zzx.java.base.agent.dynamicAgent.agentOnCglib;

import org.springframework.cglib.proxy.Enhancer;

public class Test {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetClass.class);
        enhancer.setCallback(new MyMethodInterceptor());

        TargetClass target = (TargetClass) enhancer.create();

        target.publicMethod1();
        System.out.println("=========================这是一条分界线=========================");
        target.finalMethod();
        System.out.println("=========================还是一条分界线=========================");
        target.publicMethod2();
    }
}
