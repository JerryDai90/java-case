package fun.lsof.spring.tx.demo.config;

import fun.lsof.spring.tx.demo.user.UserService;
import fun.lsof.spring.tx.demo.utils.InsertUtil;
import org.aspectj.lang.annotation.Aspect;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DBConfig {

    public static String init(JdbcTemplate jdbcTemplate){
        InsertUtil.initTable(jdbcTemplate);
        return "";
    }

}
