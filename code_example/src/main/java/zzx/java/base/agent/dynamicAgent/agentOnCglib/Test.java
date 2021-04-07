package zzx.java.base.agent.dynamicAgent.agentOnCglib;

import org.springframework.cglib.proxy.Enhancer;

public class Test {

    public static void main(String[] args) {
        // 用于创建代理对象的增强器，可以对目标对象进行扩展
        Enhancer enhancer = new Enhancer();
        // 将目标对象设置为父类
        enhancer.setSuperclass(TargetClass.class);
        // 绑定代理对象
        enhancer.setCallback(new MyMethodInterceptor());

        TargetClass target = (TargetClass) enhancer.create();

        target.publicMethod1();
        System.out.println("=========================这是一条分界线=========================");
        target.finalMethod();
        System.out.println("=========================还是一条分界线=========================");
        target.publicMethod2();
    }
}
