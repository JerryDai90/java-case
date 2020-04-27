package fun.lsof.javacore.proxy.dynamic.aop;

import fun.lsof.javacore.proxy.dynamic.Bus;
import fun.lsof.javacore.proxy.dynamic.ICar;
import fun.lsof.javacore.proxy.dynamic.ProxyGeneratorTest;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 高仿Spring AOP 的 ProxyFactory.
 * <p>
 * 我们使用 ProxyGeneratorTest 中的方式来实现 AOP
 *
 * @author jerry
 * @date 2020 -04-27 12:57:23
 */
public class ProxyFactory implements InvocationHandler {

    private Object target;

    private Class[] clazz;

    private MethodAdvice advice;

    private static AtomicInteger count = new AtomicInteger();


    public void setTarget(Object target) {
        this.target = target;
    }

    public void setInterfaces(Class... clazz) {
        this.clazz = clazz;
    }

    public void setAdvice(MethodAdvice advice) {
        this.advice = advice;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        advice.before(method, args, target);
        Object invoke = method.invoke(target, args);
        advice.afterReturning(invoke, method, args, target);

        return invoke;
    }


    public <T> T getProxy() throws Exception {
        if( null == target ){
            throw new RuntimeException("target can not be null!");
        }
        if( null == clazz ){
            throw new RuntimeException("clazz can not be null!");
        }
        if( null == advice ){
            throw new RuntimeException("advice can not be null!");
        }


        String proxyClassStr = "com.proxy.Proxy" + count.addAndGet(1);

        //动态生成Class 文件
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxyClassStr, clazz);

        //写入ClassPath 中，这样 class.forName才能找到。
        writeProxyFileToDir(proxyClassFile, proxyClassStr);

        //常用的方式，加载到内存中去
        Class<?> proxyClassObj = Class.forName(proxyClassStr);

        T proxyObj = getProxy(target, proxyClassObj);

        return proxyObj;
    }


    /**
     * 获取代理对象.
     *
     * @param <T>    type parameter
     * @param target 被代理对象
     * @param proxy  代理对象的class对象
     * @return proxy
     * @throws Exception exception
     * @author jerry
     * @date 2020 -04-27 09:23:49
     */
    private <T> T getProxy(Object target, Class proxy) throws Exception {

        //动态构建使用 ProxyGenerator 生成的代理类，此代理类只有一个构造函数，就是需要传入 InvocationHandler 的。
        T proxyObj = (T) proxy.getConstructor(InvocationHandler.class).newInstance(this);

        return proxyObj;
    }

    private String writeProxyFileToDir(byte[] proxyClassFile, String proxyClassStr) throws Exception {

        String classFiles = findClassPathAndCreated(proxyClassStr);

        // 写入文件，其实也可以直接通过流来加载 class 对象
        FileOutputStream fileWriter = new FileOutputStream(classFiles);
        fileWriter.write(proxyClassFile);
        fileWriter.flush();

        return classFiles;
    }

    private String findClassPathAndCreated(String proxyClassStr) {

        URL resource = ProxyGeneratorTest.class.getClassLoader().getResource("");
        String classFiles = resource.getPath() + proxyClassStr.replaceAll("\\.", "/") + ".class";

        //创建目录
        File file = new File(classFiles);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        System.out.println("生成的class 文件：" + classFiles);
        return classFiles;
    }

}
