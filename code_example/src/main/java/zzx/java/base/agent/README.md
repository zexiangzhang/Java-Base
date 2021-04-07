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

### 原理

    动态生成一个要代理类的子类，子类重写要代理的类的所有不是final的方法
    在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势将横切逻辑织入目标对象

### cglib一般的实现流程如下

	1. 引入cglib的依赖
		maven工程可以添加如下依赖：
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-core</artifactId>
			</dependency>
		非maven工程需要添加cglib-version.jar和asm-version.jar
		
	2. 定义目标对象
	
	3.定义拦截器
	    在调用目标对象的方法时，CGLib会回调MethodInterceptor接口的intercept方法实施拦截，来切入代理逻辑，类似于JDK中的InvocationHandler接口
	    
	4.在需要使用目标对象的时候，通过CGLIB动态代理获取代理对象
	
CGLIB的Enhancer指定要代理的目标对象(即包含实际业务逻辑的对象),再通过调用create()方法得到代理对象,所有对代理对象的非final方法的调用都会指派给AtmInterceptor.intercept()方法,在intercept()方法中可以加入目标对象之外的业务逻辑，比如参数校验、日志审计、安全检查等功能,通过调用MethodProxy.invokeSuper()方法，将调用转发给原始对象,CGLIG中MethodInterceptor的作用与JDK代理中的InvocationHandler类似，都是方法调用的中转派发

### 相关源码

	// 首先创建Enhancer对象
	Enhancer enhancer = new Enhancer();
	// 然后设置超类Superclass
	enhancer.setSuperclass(TargetClass.class);
	// 设置自定义的回调对象Callback
	enhancer.setCallback(new MyMethodInterceptor());
	// 生成超类的子类
	TargetClass target = (TargetClass) enhancer.create();
	
###### 其中enhancer.create();

	// 代码在org.springframework.cglib.proxy中的Enhancer下
	public Object create() {
        this.classOnly = false;
        this.argumentTypes = null;
        return this.createHelper();
    }
	
	private Object createHelper() {
        this.preValidate();
        Object key = KEY_FACTORY.newInstance(this.superclass != null ? this.superclass.getName() : null, ReflectUtils.getNames(this.interfaces), this.filter == ALL_ZERO ? null : new WeakCacheKey(this.filter), this.callbackTypes, this.useFactory, this.interceptDuringConstruction, this.serialVersionUID);
        this.currentKey = key;
        Object result = super.create(key);
        return result;
    }
	
###### 其中createHelper方法中的super.create(key);
	// 代码在org.springframework.cglib.core中的AbstractClassGenerator下
	protected Object create(Object key) {
        try {
			//获取当前类加载器，应用类加载器
            ClassLoader loader = this.getClassLoader();
            Map<ClassLoader, AbstractClassGenerator.ClassLoaderData> cache = CACHE;
            AbstractClassGenerator.ClassLoaderData data = (AbstractClassGenerator.ClassLoaderData)cache.get(loader);
            if (data == null) {
                Class var5 = AbstractClassGenerator.class;
                synchronized(AbstractClassGenerator.class) {
                    cache = CACHE;
                    data = (AbstractClassGenerator.ClassLoaderData)cache.get(loader);
                    if (data == null) {
                        Map<ClassLoader, AbstractClassGenerator.ClassLoaderData> newCache = new WeakHashMap(cache);
                        //创建AbstractClassGenerator
						data = new AbstractClassGenerator.ClassLoaderData(loader);
                        newCache.put(loader, data);
                        CACHE = newCache;
                    }
                }
            }
            this.key = key;
			//调用 get方法获取字节码，如果没有字节码，则会创建字节码
            Object obj = data.get(this, this.getUseCache());
            return obj instanceof Class ? this.firstInstance((Class)obj) : this.nextInstance(obj);
        } catch (Error | RuntimeException var9) {
            throw var9;
        } catch (Exception var10) {
            throw new CodeGenerationException(var10);
        }
    }
	
	public Object get(AbstractClassGenerator gen, boolean useCache) {
		if (!useCache) {
			return gen.generate(this);
		} else {
			Object cachedValue = this.generatedClasses.get(gen);
			return gen.unwrapCachedValue(cachedValue);
		}
	}
	
	protected Class generate(AbstractClassGenerator.ClassLoaderData data) {
        Object save = CURRENT.get();
        CURRENT.set(this);
        try {
            ClassLoader classLoader = data.getClassLoader();
            if (classLoader == null) {
                throw new IllegalStateException("ClassLoader is null while trying to define class " + this.getClassName() + ". It seems that the loader has been expired from a weak reference somehow. Please file an issue at cglib's issue tracker.");
            } else {
                String className;
                synchronized(classLoader) {
                    className = this.generateClassName(data.getUniqueNamePredicate());
                    data.reserveName(className);
                    this.setClassName(className);
                }

                Class gen;
                if (this.attemptLoad) {
                    try {
                        gen = classLoader.loadClass(this.getClassName());
                        Class var23 = gen;
                        return var23;
                    } catch (ClassNotFoundException var19) {
                    }
                }

                byte[] b = this.strategy.generate(this);
                className = ClassNameReader.getClassName(new ClassReader(b));
                ProtectionDomain protectionDomain = this.getProtectionDomain();
                synchronized(classLoader) {
                    gen = ReflectUtils.defineClass(className, b, classLoader, protectionDomain, this.contextClass);
                }

                Class var8 = gen;
                return var8;
            }
        } catch (Error | RuntimeException var20) {
            throw var20;
        } catch (Exception var21) {
            throw new CodeGenerationException(var21);
        } finally {
            CURRENT.set(save);
        }
    }

###### 其中generate方法中的ReflectUtils.defineClass(className, b, classLoader, protectionDomain, this.contextClass);

	public static Class defineClass(String className, byte[] b, ClassLoader loader, ProtectionDomain protectionDomain, Class<?> contextClass) throws Exception {
        Class c = null;
        Lookup lookup;
        if (contextClass != null && contextClass.getClassLoader() == loader && privateLookupInMethod != null && lookupDefineClassMethod != null) {
            try {
                lookup = (Lookup)privateLookupInMethod.invoke((Object)null, contextClass, MethodHandles.lookup());
                c = (Class)lookupDefineClassMethod.invoke(lookup, b);
            } catch (InvocationTargetException var14) {
                Throwable target = var14.getTargetException();
                if (target.getClass() != LinkageError.class && target.getClass() != IllegalArgumentException.class) {
                    throw new CodeGenerationException(target);
                }
            } catch (Throwable var15) {
                throw new CodeGenerationException(var15);
            }
        }

        if (c == null) {
            if (protectionDomain == null) {
                protectionDomain = PROTECTION_DOMAIN;
            }

            try {
                Method publicDefineClass = loader.getClass().getMethod("publicDefineClass", String.class, byte[].class, ProtectionDomain.class);
                c = (Class)publicDefineClass.invoke(loader, className, b, protectionDomain);
            } catch (InvocationTargetException var12) {
                if (!(var12.getTargetException() instanceof UnsupportedOperationException)) {
                    throw new CodeGenerationException(var12.getTargetException());
                }
            } catch (Throwable var13) {
            }

            if (c == null && classLoaderDefineClassMethod != null) {
                Object[] args = new Object[]{className, b, 0, b.length, protectionDomain};

                try {
                    if (!classLoaderDefineClassMethod.isAccessible()) {
                        classLoaderDefineClassMethod.setAccessible(true);
                    }

                    c = (Class)classLoaderDefineClassMethod.invoke(loader, args);
                } catch (InvocationTargetException var10) {
                    throw new CodeGenerationException(var10.getTargetException());
                } catch (Throwable var11) {
                    if (!var11.getClass().getName().endsWith("InaccessibleObjectException")) {
                        throw new CodeGenerationException(var11);
                    }
                }
            }
        }

        if (c == null && contextClass != null && contextClass.getClassLoader() != loader && privateLookupInMethod != null && lookupDefineClassMethod != null) {
            try {
                lookup = (Lookup)privateLookupInMethod.invoke((Object)null, contextClass, MethodHandles.lookup());
                c = (Class)lookupDefineClassMethod.invoke(lookup, b);
            } catch (InvocationTargetException var8) {
                throw new CodeGenerationException(var8.getTargetException());
            } catch (Throwable var9) {
                throw new CodeGenerationException(var9);
            }
        }

        if (c == null) {
            throw new CodeGenerationException(THROWABLE);
        } else {
            Class.forName(className, true, loader);
            return c;
        }
    }
	
###### 总结一下大概就是三个步骤：
(1) 在generate方法中通过byte[] b = this.strategy.generate(this)生成指定类的Class对象字节数组

(2) 在ReflectUtils.defineClass方法中通过(Class)classLoaderDefineClassMethod.invoke(loader, args)将Class对象字节数组转换为Class对象

(3) 在ReflectUtils.defineClass方法中通过Class.forName方法将Class对象装载到JVM
	

###### [代码示例](https://github.com/zexiangzhang/Java-Base/tree/main/code_example/src/main/java/zzx/java/base/agent/dynamicAgent/agentOnCglib)
	


	
	
	
	
	
	
	
	
	
	

