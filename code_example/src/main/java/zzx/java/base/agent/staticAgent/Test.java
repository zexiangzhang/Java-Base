package zzx.java.base.agent.staticAgent;

public class Test {

    public static void main(String[] args) {
        TargetObject targetObject = new TargetObject();
        ProxyObject proxyObject = new ProxyObject(targetObject);
        proxyObject.method();
    }

}
