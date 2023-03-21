package dao;

import org.springframework.stereotype.Repository;
import po.User;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@Repository
public class UserDao {

    public User queryUserByName(String userName){
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //执行增删改查操作
            //第一步：连接数据库
            connection = DBUtil.getConnection();
            //第二步：增删改查询的Sql语句
            String sql = "select * from tb_user where uname = ?";
            //第三步：预编译 //为什么需要预编译，原因：sql语句如果直接传入mysql服务器，mysql需要对改sql语句进行一系列的处理才能执行，对于同一条语句预编译的好出在于节省服务器的开销，提升本机访问速度
            preparedStatement = connection.prepareStatement(sql);
            //第四步：传入参数指出我们要传进去的对象（第一个？号占位符。）
            preparedStatement.setString(1,userName);
            //第五步：执行我们的sql查询
            resultSet = preparedStatement.executeQuery();
            //第六步：判断并分析结果resultSet.next()调用这方法会指出如果对象已经查到会返回1，否则返回0；
            if(resultSet.next()){
                user = User.builder().userID(resultSet.getInt("userId")).uname(userName).head(resultSet.getString("head")).mood(resultSet.getString("mood")).nick(resultSet.getString("nick")).upwd(resultSet.getString("upwd")).build();
            }
        } catch (Exception e) {
           e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,preparedStatement,connection);
        }
        return  user;
    }
}
