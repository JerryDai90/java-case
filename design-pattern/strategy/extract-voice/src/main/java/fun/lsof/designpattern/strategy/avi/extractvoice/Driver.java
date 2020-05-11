package fun.lsof.designpattern.strategy.avi.extractvoice;

import fun.lsof.designpattern.strategy.avi.extractcommon.HandleType;
import fun.lsof.designpattern.strategy.avi.extractcommon.IExtract;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Driver {

    private static final Map<String, Class> driver = new ConcurrentHashMap<String, Class>();

    public static void register(String key, Class extract){

        if( driver.containsKey(key) ){
            throw new UnsupportedOperationException("已经存在，不支持："+key);
        }
        driver.put(key, extract);
    }

    public static void init(){
        Reflections reflections = new Reflections("fun.lsof");
        Set<Class<? extends IExtract>> subTypesOf = reflections.getSubTypesOf(IExtract.class);

        subTypesOf.forEach(clazz -> {
            HandleType handleType = clazz.getAnnotation(HandleType.class);
            if( null == handleType ){
                return;
            }
            Driver.register(handleType.value(), clazz);
        });
    }

    public static IExtract get(String key){
        Class aClass = driver.get(key);
        try {
            return (IExtract)aClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("实例化失败");
        }
    }




}
