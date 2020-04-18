package fun.lsof.spring.ioc.simulation.support;

import fun.lsof.spring.ioc.simulation.annotation.Autowired;
import fun.lsof.spring.ioc.simulation.annotation.Component;
import fun.lsof.spring.ioc.simulation.exception.ComponentNotFundException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 简单实现 使用注解进行依赖注入功能，支持构造函数、成员变量注入。支持循环依赖。
 *
 * @author jerry
 * @date 2020 -03-28 16:12:00
 */
public class AnnotationApplicationContext {

    /**
     * 初始化成功后暴露到这里（最小初始化，和spring IOC 实现的原理一致）
     */
    static ThreadLocal<Map<String, Object>> discover = new ThreadLocal<Map<String, Object>>();

    /**
     * 判断构造函数是否有自动注入注解
     */
    private static boolean hasConstructorAutowired(Class<?> aClass) {
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor _c : constructors) {
            Annotation annotation = _c.getAnnotation(Autowired.class);
            if (null != annotation) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解析构造函数.
     */
    private static Object parseConstructor(Class<?> aClass) throws Exception {
        Object obj = null;

        Constructor<?>[] constructors = aClass.getConstructors();

        for (Constructor _c : constructors) {

            List<Object> params = new ArrayList<Object>();

            Annotation annotation = _c.getAnnotation(Autowired.class);

            if (null != annotation) {
                Class[] parameterTypes = _c.getParameterTypes();

                for (Class c : parameterTypes) {
                    params.add(getBean(c));
                }

                obj = _c.newInstance(params.toArray());
                break;
            }
        }
        return obj;
    }

    /**
     * 解析成员变量.
     */
    private static void parseFields(Object obj, Field[] declaredFields) throws IllegalAccessException {
        for (Field f : declaredFields) {
            Autowired annotation = f.getAnnotation(Autowired.class);
            if (null != annotation) {
                Object fObj = getBean(f.getType());
                f.setAccessible(true);
                f.set(obj, fObj);
            }
        }
    }


    private static boolean hasComponent(Class clazz){
        return clazz.getAnnotationsByType(Component.class).length != 0;
    }


    /**
     * 获取对象实例.
     */
    public static <T> T getBean(Class<T> t) {
        Map<String, Object> threadData = discover.get();
        if (null == threadData) {
            discover.set(new HashMap<String, Object>());
            threadData = discover.get();
        }

        try {
            String name = t.getName();

            if (threadData.containsKey(name)) {
                return (T) threadData.get(name);
            }

            Class<?> aClass = Class.forName(name);
            Object obj = null;


            if( !hasComponent(aClass) ){
                throw new ComponentNotFundException("@Component not find in "+aClass.getName());
            }

            //优先判断构造函数
            if (hasConstructorAutowired(aClass)) {
                //构造函数注入
                obj = parseConstructor(aClass);
            } else {
                //先暴露出去
                obj = aClass.newInstance();
            }
            threadData.put(name, obj);

            //成员变量
            Field[] declaredFields = aClass.getDeclaredFields();
            if (declaredFields.length != 0) {
                parseFields(obj, declaredFields);
            }

            return (T) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
