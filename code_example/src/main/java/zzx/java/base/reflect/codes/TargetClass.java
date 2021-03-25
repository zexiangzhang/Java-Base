package zzx.java.base.reflect.codes;

public class TargetClass extends ParentTargetClass {

    private String sex;

    public int codeLevel;

    public TargetClass() {}

    public String getSex() { return this.sex; }

    public void setSex(String sex) { this.sex = sex; }

    public String askSex() {
        return "public method!!! sex is : " + sex;
    }

    private String askSexQuite() {
        return "private method execute!!! sex is : " + sex;
    }
}
