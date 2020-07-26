package fun.lsof.spring.tx.demo.example;

import fun.lsof.spring.tx.demo.config.SpringJunitTest;
import fun.lsof.spring.tx.demo.utils.InsertUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import static org.junit.Assert.*;

public class Test1 extends SpringJunitTest {

    @Autowired
    RequiresNewTest newTest;

    //测试
    @Test
    public void t1() {

        try {
            newTest.t1();
        } catch (Exception e) {
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }

//        assertTrue(newTest.hasId(1));
//        assertTrue(newTest.hasId(2));

        System.out.println(newTest.hasId(1));
        System.out.println(newTest.hasId(2));

        System.out.println(newTest.queryAll());

        //先插入一条记录
//        newTest.insert(100);
//
//        System.out.println(newTest.queryAll());
//        System.out.println(newTest.countAll());
//
//        newTest.delete(11);
//
//        System.out.println(newTest.hasId(11));
//
//        System.out.println(newTest.hasId(9));

//        newTest.t1();
    }


//    @Autowired
//    DataSource dataSource;

//    @Test
//    @Transactional
//    public void testadd90(){
//        System.out.println("1:"+this);
//
//
////        Test1 t = (Test1)AopContext.currentProxy();
//        this.testadd3();
//
//
//    }

//    @Test
////    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void testadd3(){
//        System.out.println("2>1"+dataSource);
//        System.out.println("2:"+this);
//
//        InsertUtil.addUser(jdbcTemplate);
////        throw new RuntimeException();
//        System.out.println(InsertUtil.queryAll(jdbcTemplate));
//    }

//    @After
//    public void testadd2(){
//        System.out.println("222:"+this);
//
//        System.out.println(InsertUtil.queryAll(jdbcTemplate));
//
//    }
//
//
//
//    @Test
//    public void testadd902() throws InterruptedException {
//        System.out.println("3>1"+dataSource);
//        System.out.println("3:"+this);
////        InsertUtil.addUser(jdbcTemplate);
//        System.out.println(InsertUtil.queryAll(jdbcTemplate));
//
////        jdbcTemplate.execute(":111");
//    }

}
