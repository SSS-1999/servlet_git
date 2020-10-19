package dao;

import pojo.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//这个类是用来操作tb_user表的CRUD操作
public class UserDao {

    //写一个添加用户数据的方法  对于添加操作  、删除操作、修改操作
    //方法的返回值都可以是表中数据的受影响的行数 int
    // 查询 将每一条数据封装一个对象中，将多个对象添加集合中
    public int addUserInfo(String name, String pwd) {
        //获取数据库连接对象
        Connection conn = null;
        PreparedStatement ps = null;
        int row = 0;

        try {
            conn = DBUtil.getConn();
            System.out.println("conn:" + conn);
            //写sql
            String sql = "insert into tb_user(id,name,password,tel) values(null,?,?,?)";
            ps = conn.prepareStatement(sql);
            //给问号赋值
            ps.setString(1, name);
            ps.setString(2, pwd);
            ps.setString(3, "13411375191");

            //执行
            row = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return row;
    }


    //封装一个方法   根据用户名查询当前用户是否存在
    public User findUserByUserName(String name) {
        //获取数据库连接对象
        Connection conn = DBUtil.getConn();
        User user = null;
        //编写sql
        String sql = "select * from tb_user where name=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            // 给问号赋值
            ps.setString(1, name);

            //执行
            ResultSet r = ps.executeQuery();

            if (r.next()) {
                int id = r.getInt("id");
                String username = r.getString("name");
                String pwd = r.getString("password");
                String tel = r.getString("tel");
                //得到结果封装到User对象
                //将从数据库拿到的这条数据封装到一个User对象
                user = new User();
                user.setId(id);
                user.setName(username);
                user.setPassword(pwd);
                user.setTel(tel);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭连接
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;

    }

    //查询tb_user表中所有数据
    public List<User> findAllUserInfo() {
        List<User> list = new ArrayList<>();
        //获取数据库连接
        Connection connection = DBUtil.getConn();
        //编写sql
        String sql = "select * from tb_user";

        try {
            // PreparedStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            //因为没有参数 不用给问号赋值  省略
            ResultSet r = ps.executeQuery();
            //遍历结果集 ，将数据封装到User对象，将对象添加到集合中
            while (r.next()) {
                Integer id = r.getInt("id");
                String name = r.getString("name");
                String pwd = r.getString("password");
                String phone = r.getString("tel");
                //将得到的数据封装到对象
                User user = new User();
                user.setId(id);
                user.setPassword(pwd);
                user.setName(name);
                user.setTel(phone);
                //将封装数据的对象添加到集合中
                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    //根据id删除数据
    public int deleteUserById(String id){
        int row=0;
    //获取数据库连接
        Connection conn=DBUtil.getConn();
        //编写sql
        String sql="delete  from tb_user where id=?";

        try {
            // 创建 PreparedStatement对象
            PreparedStatement ps= conn.prepareStatement(sql);
            //给问号赋值
            ps.setInt(1,Integer.parseInt(id));
            //执行
           row=ps.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  row;
    }

}
