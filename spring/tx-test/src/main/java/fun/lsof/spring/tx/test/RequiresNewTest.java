package fun.lsof.spring.tx.test;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
//@Transactional(propagation = Propagation.REQUIRED)
@Transactional
public class RequiresNewTest extends AbsRoot {


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void t1() {

        insertById(1);

//        addUser2();
//        try {
            getProxy(this).addUser2();
////            addUser2();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        insertById(1);
//        throw new NullPointerException();


//        getProxy(this).addUser2();
//        Object o = AopContext.currentProxy();
//        System.out.println(o);

//        try{
//            addUser2();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        addUserThrow2();
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addUser2() {
        insertById(2);
//        insertById(3);
//        throw new RuntimeException();
    }

    public void addUserThrow2() {
        throw new RuntimeException();
    }


}
