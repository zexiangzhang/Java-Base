package zzx.java.base.reflect.codes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        try {
            Class<?> clazz1 = Class.forName("zzx.java.base.reflect.codes.TargetClass");
            System.out.println(clazz1.getSimpleName());
            System.out.println(clazz1.getTypeName());
            System.out.println("-----------------------------------第一条分界线-----------------------------------");
            Class<?> clazz2 = TargetClass.class;
            System.out.println(clazz2.getSimpleName());
            System.out.println(clazz2.getTypeName());
            System.out.println("-----------------------------------第二条分界线-----------------------------------");
            TargetClass tempClass = new TargetClass();
            Class<? extends TargetClass> clazz3 = tempClass.getClass();
            System.out.println(clazz3.getSimpleName());
            System.out.println(clazz3.getTypeName());
            System.out.println("-----------------------------------第三条分界线-----------------------------------");
            Constructor<?> constructor = clazz1.getConstructor();
            // 获取构造器中的参数数量
            System.out.println(constructor.getParameterCount());
            try {
                Object clazz4 = constructor.newInstance();
                System.out.println(clazz4.getClass().getTypeName());
                System.out.println(clazz4.getClass().getTypeName());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println("-----------------------------------第四条分界线-----------------------------------");
            Class<TargetClass> tempClazz5 = TargetClass.class;
            try {
                TargetClass clazz5 = tempClazz5.newInstance();
                clazz5.setSex("male");
                System.out.println(clazz5.getSex());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println("-----------------------------------第五条分界线-----------------------------------");
            // 获得类及其父类中所有的public字段
            Field[] publicFields = clazz1.getFields();
            if (publicFields.length > 0) {
                System.out.print("类及其父类所有的公共字段如下： ");
                Arrays.stream(publicFields).forEach(field -> System.out.print(field.getName() + " "));
                System.out.println();
            }
            System.out.println("-----------------------------------第六条分界线-----------------------------------");
            // 获得某个类的所有的字段,但是不包括父类中的字段
            Field[] allFields = clazz1.getDeclaredFields();
            if (allFields.length > 0) {
                System.out.print("类中所有的字段如下： ");
                Arrays.stream(allFields).forEach(field -> System.out.print(field.getName() + " "));
                System.out.println();
            }
            System.out.println("-----------------------------------第七条分界线-----------------------------------");
            Method publicMethodGet = clazz1.getMethod("getSex");
            Method publicMethodSet = clazz1.getMethod("setSex", String.class);
            // 获取方法的返回值
            System.out.println(publicMethodGet.getReturnType());
            System.out.println(publicMethodSet.getReturnType());
            System.out.println("-----------------------------------第八条分界线-----------------------------------");
            Method[] allMethods = clazz1.getDeclaredMethods();
            if (allMethods.length > 0) {
                System.out.println("类中所有的方法名如下： ");
                Arrays.stream(allMethods).forEach(method -> System.out.print(method.getName() + " "));
                System.out.println();
            }
            System.out.println("-----------------------------------第九条分界线-----------------------------------");
            Method privateMethod = TargetClass.class.getDeclaredMethod("askSexQuite");
            TargetClass clazz6 = new TargetClass();
            clazz6.setSex("male");
            try {
                System.out.println(privateMethod.invoke(clazz6));
            } catch (IllegalAccessException e) {
                System.out.println("不能执行私有方法,将会报错，错误信息为：" + e.getMessage());
            }
            System.out.println("-----------------------------------第十条分界线-----------------------------------");
            privateMethod.setAccessible(true);
            try {
                System.out.println(privateMethod.invoke(clazz6));
                System.out.println("这里就不会报错");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | NoSuchMethodException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
