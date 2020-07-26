package fun.lsof.spring.tx.custom;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DataSourceManager {

    public static class Resources {

        public Map<String, Object> connect = new HashMap<String, Object>();
        public Connection currentConnect;

        public Resources(Map<String, Object> connect, Connection currentConnect) {
            this.connect = connect;
            this.currentConnect = currentConnect;
        }

        public Resources() {
        }
    }

    public final static ThreadLocal<Resources> res = new ThreadLocal<Resources>();

    public static Connection getCurrent(DataSource dataSource) {
        //TODO 有可能是多数据源，这里要判断
        return res.get().currentConnect;
    }


    public static Connection getConnection(DataSource dataSource) {
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static Connection getConnection(DataSource dataSource, String key) {
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void setConnect(DataSource dataSource, String key) {
        Resources resources = res.get();
        if (null == resources) {
            resources = new Resources();
        }

        resources.currentConnect = getConnection(dataSource);
        try {
            resources.currentConnect.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resources.connect.put(key, resources.currentConnect);

        res.set(resources);

    }


}
