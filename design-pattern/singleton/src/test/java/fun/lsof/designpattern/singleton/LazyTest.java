package fun.lsof.designpattern.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class EagerTest {

    @Test
    public void TestCreate(){
        Eager instance = Eager.getInstance();

        System.out.println(instance);
        System.out.println(instance);
    }


    @Test
    public void TestCreate4Ref() throws Exception {

        Constructor<Eager> declaredConstructor = Eager.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        try{
            Eager eager = declaredConstructor.newInstance();

            Assert.fail("已经获取到了新对象了"+eager.toString());
        }catch (Exception e){
            Assert.assertTrue(e.getCause() instanceof RuntimeException);
        }
    }


    @Test
    public void TestCreate4Thread(){
        for (int i = 0; i < 40; i++) {
            new Thread(()->{
                Eager instance = Eager.getInstance();
                System.out.println(instance);
            }).start();
        }
    }




}
