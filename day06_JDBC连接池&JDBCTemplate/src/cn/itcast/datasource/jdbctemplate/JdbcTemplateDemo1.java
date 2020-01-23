package cn.itcast.datasource.jdbctemplate;

import cn.itcast.datasource.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * JdbcTemplate quick start
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //创建JDBCTemplate对象
        DataSource ds = JDBCUtils.getDataSource();
        JdbcTemplate template = new JdbcTemplate(ds);
        //执行SQL
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql,7);
        System.out.println(count);
        //资源自动归还
    }

}
