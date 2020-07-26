package fun.lsof.spring.tx.demo.example;

import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Component
//@Transactional(propagation = Propagation.REQUIRES_NEW)
//@Transactional
public class RequiresNewTest extends AbsRoot {


//    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = CloneNotSupportedException.class)


    @Transactional(propagation= REQUIRES_NEW)
    public void t1() {

//        addUser2();

//        try {
//
//        }catch (Exception e){
//
//        }

        insertById(1);


//        getProxy(this).t3();

//        try {
//            getProxy(this).t3();
//        }catch (Exception e){
//
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

    @Transactional(propagation= REQUIRES_NEW)
    public void t3() {
        getProxy(this).addUser2();
    }


    @Transactional(propagation = REQUIRED)
    public void addUser2() {
        insertById(2);
        insertById(3);
        throw new RuntimeException();
    }

    public void addUserThrow2() {
        throw new RuntimeException();
    }


}
