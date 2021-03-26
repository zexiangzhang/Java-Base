package zzx.java.base.agent.dynamicAgent.agentOnCglib;

public class TargetClass {

    public TargetClass() {}

    final public void finalMethod() {
        System.out.println("这是TargetClass中的final方法");
    }

    public void publicMethod1() {
        System.out.println("这是TargetClass中的public方法1");
    }

    public void publicMethod2() {
        System.out.println("这是TargetClass中的public方法2");
    }

}
