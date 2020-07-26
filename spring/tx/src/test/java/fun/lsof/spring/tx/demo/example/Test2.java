//package fun.lsof.spring.tx.demo.example;
//
//import fun.lsof.spring.tx.demo.config.SpringJunitTest;
//import fun.lsof.spring.tx.demo.utils.InsertUtil;
//import org.junit.After;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.sql.DataSource;
//
//public class Test2 extends SpringJunitTest {
//
//
//    @Autowired
//    DataSource dataSource;
//
////    @Test
////    @Transactional
////    public void testadd90(){
////        System.out.println("1:"+this);
////
////
//////        Test1 t = (Test1)AopContext.currentProxy();
////        this.testadd3();
////
////
////    }
//
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
//
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
//
//}
