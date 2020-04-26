package fun.lsof.javacore.proxy.dynamic;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class ProxyGeneratorTest {


    public static void main(String[] args) throws Exception {

        String proxyClassStr = "com.proxy.CarProxy";

        //动态生成Class 文件
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxyClassStr, new Class[]{ICar.class});

        //写入ClassPath 中，这样 class.forName才能找到。
        writeProxyFileToDir(proxyClassFile, proxyClassStr);

        //常用的方式，加载到内存中去
        Class<?> proxyClassObj = Class.forName(proxyClassStr);

        //构建需要代理的对象
        final ICar target = new Bus();

        ICar proxyObj = getProxy(target, proxyClassObj);

        //使用代理对象的服务，会输出被代理对象已经代理对象的增强
        proxyObj.start();
        proxyObj.run();
        proxyObj.stop();
    }

    public static String writeProxyFileToDir(byte[] proxyClassFile, String proxyClassStr) throws Exception {

        String classFiles = findClassPathAndCreated(proxyClassStr);

        // 写入文件，其实也可以直接通过流来加载 class 对象
        FileOutputStream fileWriter = new FileOutputStream(classFiles);
        fileWriter.write(proxyClassFile);
        fileWriter.flush();

        return classFiles;
    }



    public static String findClassPathAndCreated(String proxyClassStr){

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


    /**
     * 获取代理对象.
     *
     * @param <T>   type parameter
     * @param target  被代理对象
     * @param proxy 代理对象的class对象
     * @return proxy
     * @throws Exception exception
     * @author jerry
     * @date 2020 -04-27 09:23:49
     */
    public static <T> T getProxy(Object target, Class proxy) throws Exception {

        //动态构建使用 ProxyGenerator 生成的代理类，此代理类只有一个构造函数，就是需要传入 InvocationHandler 的。
        T proxyObj = (T) proxy.getConstructor(InvocationHandler.class).newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("call in IH : " + method.getName());
                method.invoke(target, args);
                return null;
            }
        });

        return proxyObj;
    }


}
