package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //1.获取DataSource
        //DataSource ds = new ComboPooledDataSource();
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        //2.获取连接
        for(int i=1;i<=10;i++){
            Connection conn = ds.getConnection();
            System.out.println(conn);
        }
    }
}
