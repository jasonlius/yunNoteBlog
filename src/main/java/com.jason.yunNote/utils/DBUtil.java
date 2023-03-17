package utils;

import com.sun.java.swing.plaf.windows.WindowsDesktopPaneUI;

import javax.swing.table.TableRowSorter;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {


    private static Properties properties = new Properties();
    //读取配置文件db.properties
    static {
        InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");

        try {
            properties.load(inputStream);
            Class.forName(properties.getProperty("jdbcName"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //连接数据库的方法
    public  static Connection getConnection() {
        String dbUrl = properties.getProperty("dbUrl");
        String dbName = properties.getProperty("dbName");
        String dbPwd = properties.getProperty("dbPwd");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbName, dbPwd);

        } catch (SQLException SqlExcp) {
            SqlExcp.printStackTrace();
        }
        return connection;
    }

    //关闭数据库的方法
    public static void close(ResultSet resultSet,
                             PreparedStatement preparedStatement,
                             Connection connection){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
