# 代理模式

***代理模式是设计模式中的一种，旨在为其他对象提供一种代理以控制对这个对象的访问***

**这样做的好处就是可以在目标对象实现的功能基础上，增加额外的功能，也就是扩展目标对象的功能**

代理分为**静态代理**和**动态代理**
动态代理在Java有两种实现：***基于JDK的动态代理***，***基于CGLIB的动态代理***

# 静态代理

###### 静态代理在使用时，需要定义接口或者父类，被代理对象与代理对象一起实现相同的接口或者继承相同的父类

	// 接口
	public interface InterfaceForImplements {
		void method();
	}
	
	// 被代理对象
	public class TargetObject implements InterfaceForImplements {
		public void method() {
			System.out.println("目标对象执行了");
		}
	}
	
	// 代理对象
	public class ProxyObject implements InterfaceForImplements {
		priate TargetObject targetObject;
		public ProxyObject(TargetObject targetObject) {
			this.targetObject = targetObject;
		}
		public void method() {
			System.out.println("目标对象之前执行了");
			this.targetObject.method();
			System.out.println("目标对象之后执行了");
		}
	}
	
	public class Test {
		public static void main(String[] args) {
			TargetObject targetObject = new TargetObject();
			ProxyObject proxyObject = new ProxyObject(targetObject);
			proxyObject.method();
		}
	}
	
静态代理可以***在不修改被代理对象功能的基础上，实现对被代理对象功能的扩展***

缺点也是显而易见的：第一，***类太多容易混淆***；第二，***接口增加方法后代理对象和被代理对象都要维护***，这是一种浪费

###### [代码示例](https://github.com/zexiangzhang/Java-Base/tree/main/code_example/src/main/java/zzx/java/base/agent/staticAgent)

# 动态代理

###### 在业务中使用动态代理，一般是为了在不干预实现类正常业务的前提下，给需要实现的方法添加前置或者后置操作，把一些其他业务和实现类的正常业务分离开

###### Spring的AOP原理就是基于动态代理实现的

## jdk动态代理

### jdk的动态代理是基于接口的代理，主要的实现流程如下：

	1. 创建业务接口(interface)
	
	2. 实现interface(impl)
	
	3. 创建impl的代理类(proxyClass)，实现InvocationHandler接口中的invoke方法
	
	4. 生成代理对象(java.lang.reflect.Proxy类中的newProxyInstance方法)
	
### invoke方法

java.lang.reflect.InvocationHandler中的invoke方法需要三个参数，源码如下：

	public Object invoke(Object proxy, Method method, Object[] args)
		throws Throwable;
		
从源码中的注释中知道：

	proxy参数就是对其调用方法的代理实例
		
	method参数就是对应于在代理实例上调用的接口方法的实例，对象的声明类将是在其中声明方法的接口，该接口可能是代理类通过其继承方法的代理接口的父级接口
		
	args参数包含在代理实例的方法调用中传递的参数值的对象数组，如果接口方法不带参数，则为null，基本类型的参数包装在相应基元包装类的实例中，例如Integer或Boolean

### newProxyInstance方法

源码如下：

	@CallerSensitive
    public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
        throws IllegalArgumentException
    {
        Objects.requireNonNull(h);

        final Class<?>[] intfs = interfaces.clone();
        final SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            checkProxyAccess(Reflection.getCallerClass(), loader, intfs);
        }

        /*
         * Look up or generate the designated proxy class.
         */
        Class<?> cl = getProxyClass0(loader, intfs);

        /*
         * Invoke its constructor with the designated invocation handler.
         */
        try {
            if (sm != null) {
                checkNewProxyPermission(Reflection.getCallerClass(), cl);
            }

            final Constructor<?> cons = cl.getConstructor(constructorParams);
            final InvocationHandler ih = h;
            if (!Modifier.isPublic(cl.getModifiers())) {
                AccessController.doPrivileged(new PrivilegedAction<Void>() {
                    public Void run() {
                        cons.setAccessible(true);
                        return null;
                    }
                });
            }
            return cons.newInstance(new Object[]{h});
        } catch (IllegalAccessException|InstantiationException e) {
            throw new InternalError(e.toString(), e);
        } catch (InvocationTargetException e) {
            Throwable t = e.getCause();
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new InternalError(t.toString(), t);
            }
        } catch (NoSuchMethodException e) {
            throw new InternalError(e.toString(), e);
        }
    }

##### @CallerSensitive注解
	这个注解我查了很多资料，其中很多都是说是为了堵住漏洞用的，当然实际工作中也没有发现这个注解的使用场景
		
	查阅各种博客，文章，javadoc之后，大概总结一下就是：
		jdk内有些方法，jvm的开发者认为这些方法危险，不希望开发者调用，就把这种危险的方法用@CallerSensitive修饰，并在jvm级别检查
		如Reflection.getCallerClass()方法规定，调用它的对象，必须有@CallerSensitive 注解，否则报异常 Exception in thread "main" java.lang.InternalError: CallerSensitive annotation expected at frame 1
			
	@CallerSensitive有个特殊之处，必须由启动类classloader加载(如rt.jar),才可以被识别
	
##### 从源码中就可以看出，***动态代理的思路便是生成一个新类***

	首先进行一系列的检查，然后调用getProxyClass0方法生成一个新类，查看getProxyClass0方法，源码如下：
	private static Class<?> getProxyClass0(ClassLoader loader,
                                           Class<?>... interfaces) {
        if (interfaces.length > 65535) {
            throw new IllegalArgumentException("interface limit exceeded");
        }

        // If the proxy class defined by the given loader implementing
        // the given interfaces exists, this will simply return the cached copy;
        // otherwise, it will create the proxy class via the ProxyClassFactory
        return proxyClassCache.get(loader, interfaces);
    }
	可以看出直接取proxyClassCache缓存，proxyClassCache是一个代理类的缓存变量，如果这个缓存里有这个代理类，就直接返回代理类，如果没有，就会通过ProxyClassFactory创建代理对象
	
	然后在try块中就是根据生成的class通过反射获取构造函数对象并生成代理类实例
	
	再详细......还是看源码吧，源码在java.lang.reflect.Proxy中
	
###### [代码示例](https://github.com/zexiangzhang/Java-Base/tree/main/code_example/src/main/java/zzx/java/base/agent/dynamicAgent/agentOnJdk)

## cglib动态代理

因为jdk的动态代理必须是基于接口的，在需要代理非接口类的场景下，可以使用cglib动态代理

cglib可以在运行期扩展java类或者实现java接口，例如Hibernate用它来实现PO字节码的动态生成

cglib的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类

### cglib主要的实现流程如下：

	1. 引入cglib的依赖
		maven工程可以添加如下依赖：
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-core</artifactId>
			</dependency>
		非maven工程需要添加cglib-version.jar和asm-version.jar
		
	2. 

	
	
	
	
	
	
	
	
	
	

