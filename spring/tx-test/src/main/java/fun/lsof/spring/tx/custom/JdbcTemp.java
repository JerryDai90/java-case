package fun.lsof.spring.tx.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class JdbcTemp {

    @Autowired
    DataSource dataSource;

    public void execute(final String sql) throws DataAccessException {
        class ExecuteStatementCallback implements StatementCallback<Object>, SqlProvider {
            @Override
            @Nullable
            public Object doInStatement(Statement stmt) throws SQLException {
                stmt.execute(sql);
                return null;
            }
            @Override
            public String getSql() {
                return sql;
            }
        }
        execute(new ExecuteStatementCallback());
    }


    @Nullable
    public <T> T execute(StatementCallback<T> action) throws DataAccessException {
        Assert.notNull(action, "Callback object must not be null");

        Connection con = DataSourceManager.getCurrent(dataSource);

        System.out.println(con.toString());
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            T result = action.doInStatement(stmt);
            return result;
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        finally {
            JdbcUtils.closeStatement(stmt);
        }
    }

    public SqlRowSet queryForRowSet(String sql) throws DataAccessException {
        return result(query(sql, new SqlRowSetResultSetExtractor()));
    }
    private static <T> T result(@Nullable T result) {
        Assert.state(result != null, "No result");
        return result;
    }


    @Nullable
    public <T> T query(final String sql, final ResultSetExtractor<T> rse) throws DataAccessException {
        Assert.notNull(sql, "SQL must not be null");
        Assert.notNull(rse, "ResultSetExtractor must not be null");

        /**
         * Callback to execute the query.
         */
        class QueryStatementCallback implements StatementCallback<T>, SqlProvider {
            @Override
            @Nullable
            public T doInStatement(Statement stmt) throws SQLException {
                ResultSet rs = null;
                try {
                    rs = stmt.executeQuery(sql);
                    return rse.extractData(rs);
                }
                finally {
                    JdbcUtils.closeResultSet(rs);
                }
            }
            @Override
            public String getSql() {
                return sql;
            }
        }

        return execute(new QueryStatementCallback());
    }
    public <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException {
        return result(query(sql, new RowMapperResultSetExtractor<>(rowMapper)));
    }

    public Map<String, Object> queryForMap(String sql) throws DataAccessException {
        return result(queryForObject(sql, getColumnMapRowMapper()));
    }
    @Nullable
    public <T> T queryForObject(String sql, RowMapper<T> rowMapper) throws DataAccessException {
        List<T> results = query(sql, rowMapper);
        return DataAccessUtils.nullableSingleResult(results);
    }
    protected RowMapper<Map<String, Object>> getColumnMapRowMapper() {
        return new ColumnMapRowMapper();
    }

    public <T> T queryForObject(String sql, Class<T> requiredType) throws DataAccessException {
        return queryForObject(sql, getSingleColumnRowMapper(requiredType));
    }
    protected <T> RowMapper<T> getSingleColumnRowMapper(Class<T> requiredType) {
        return new SingleColumnRowMapper<>(requiredType);
    }
    public List<Map<String, Object>> queryForList(String sql) throws DataAccessException {
        return query(sql, getColumnMapRowMapper());
    }


    public DataSource getDataSource(){
        return this.dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
