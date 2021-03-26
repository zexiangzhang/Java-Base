package zzx.java.base.agent.dynamicAgent.agentOnJdk;

public class BusinessInterfaceImpl implements BusinessInterface {

    @Override
    public void printSomeThing(String param) {
        System.out.println("被代理对象执行了，打印： " + param);
    }

    @Override
    public String returnSomeThing(String param) {
        return param + "被执行了";
    }
}
