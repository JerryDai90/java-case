//package fun.lsof.spring.tx.demo.config;
//
//import fun.lsof.spring.tx.demo.user.UserService;
//import fun.lsof.spring.tx.demo.utils.InsertUtil;
//import org.aspectj.lang.annotation.Aspect;
//import org.h2.tools.Server;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.*;
//import org.springframework.core.annotation.Order;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
//@org.springframework.context.annotation.Configuration
//@ComponentScan("fun.lsof.spring.tx.*")
////@expose
////@EnableTransactionManagement(proxyTargetClass = true, mode = AdviceMode.ASPECTJ)
//@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
//@ImportResource(locations = "classpath:spring-aop-by-custom.xml")
//public class Configuration {
//
//    @Bean
//    public void initDB() throws SQLException {
//        Server.createTcpServer(
//                "-tcp", "-tcpAllowOthers", "-tcpPort", "8043"
//        ).start();
//    }
//
//    @Bean
//    public DataSource dataSource() throws SQLException {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//
//        return dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource source) throws SQLException {
//        return new JdbcTemplate(source);
//    }
//
//    @Bean
//    public DataSourceTransactionManager dataSourceTransactionManager(DataSource source){
//        return new DataSourceTransactionManager(source);
//    }
//
//
//    @Bean
//    public String init(JdbcTemplate jdbcTemplate){
//        InsertUtil.initTable(jdbcTemplate);
//        return "";
//    }
//
//
//}
