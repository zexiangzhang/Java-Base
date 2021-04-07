# 反射

反射是在运行状态中：

**对于任意一个类，都能够知道这个类的所有属性和方法；**

**对于任意一个对象，都能够调用它的任意一个方法和属性；**

##### 反射机制的作用

	在运行时判断任意一个对象所属的类
	在运行时构造任意一个类的对象
	在运行时判断任意一个类所具有的成员变量和方法
	在运行时调用任意一个对象的方法
	
##### 反射机制的优缺点

	优点：可以动态的创建对象和编译，最大限度发挥了java的灵活性
	缺点：对性能有影响，使用反射基本上一种解释操作，告诉JVM我们要做什么并且满足我们的要求，这类操作总是慢于直接执行java代码
	
## 一般的反射操作

#### 创建对象
    1. Class.forName("全限类名");
    2. 类名.class; 获取Class<？> clazz 对象 
    3. 对象.getClass();
    
#### 获取构造器对象，通过构造器new出一个对象
    1. Clazz.getConstructor([xxx.class]);
    2. Con.newInstance([参数]);
    
#### 通过class对象创建一个实例对象(就相当与new类名()无参构造器)
    1. Clazz.newInstance();

#### 通过class对象获得一个属性对象
    1. Field fields = clazz.getFields()：获得某个类的所有的公共(public)的字段,包括父类中的字段
    2. Field fields = clazz.getDeclaredFields()：获得某个类的所有声明的字段,即包括public、private和proteced,但是不包括父类中的字段
     
#### 通过class对象获得一个方法对象
    1. Clazz.getMethod("方法名",class…..parameaType);(只能获取公共的)
    2. Clazz.getDeclareMethod("方法名");(获取任意修饰的方法，不能执行私有的方法)
    3. Method.setAccessible(true);（让私有的方法可以执行）

#### 让方法执行
    1. Method.invoke(obj实例对象,obj可变参数);（是有返回值的）
	
### ***[点击查看示例](https://github.com/zexiangzhang/Java-Base/tree/main/code_example/src/main/java/zzx/java/base/reflect/codes)***