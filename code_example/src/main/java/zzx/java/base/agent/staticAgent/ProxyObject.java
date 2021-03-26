package zzx.java.base.agent.staticAgent;

public class ProxyObject implements InterfaceForImplements {

    private TargetObject targetObject;

    public ProxyObject(TargetObject targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public void method() {
        System.out.println("目标对象之前执行了");
        this.targetObject.method();
        System.out.println("目标对象之后执行了");
    }

}