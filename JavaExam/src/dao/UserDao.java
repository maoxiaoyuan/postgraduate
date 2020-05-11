package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Book;
import bean.User;

public class UserDao {
	User user;
	public UserDao() {
		user=new User();
	}
    /**
     * 注册添加用户信息
     */
    public static int add(User user) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "insert into users values(?,?,?,?,?,?,?,?)";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getPhoneNumber());
            pstmt.setString(4, user.getCreditType());
            pstmt.setString(5, user.getCreditNumber());
            pstmt.setString(6, user.getEmail());
            pstmt.setString(7, user.getRole());
            pstmt.setString(8, user.getCollegeName());

            // 执行sql语句
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, conn);
        }
        return count;
    }
    
    
    /**
     * 更改用户信息
     */
    public static int update(User user) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "UPDATE users SET password=?,phone_number=?," +
        		"credit_type=?,credit_number=?,email=? ,role=?,college_name=? WHERE user_name=?";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getPhoneNumber());
            pstmt.setString(3, user.getCreditType());
            pstmt.setString(4, user.getCreditNumber());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getRole());
            pstmt.setString(7,user.getUserName());

            // 执行sql语句
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, conn);
        }
        return count;
    }


    /**
     * 删除用户根据用户名
     */
    public static int delete(String user_name) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "DELETE FROM users WHERE user_name = ?";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, user_name);
            // 执行sql语句
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, conn);
        }
        return count;
    }

    /**
     * 查询所有用户信息
     */

    public static List<User> query() {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select * from users";
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
               User user=new User(rs.getString("user_name"),rs.getString("password"),rs.getString("phone_number"),
            		   rs.getString("credit_type"),rs.getString("credit_number"),rs.getString("email"),rs.getString("role"),rs.getString("college_name"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }

        return userList;
    }
    /**
     * 查询用户信息根据登录名
     */

    public static List<User> getByUsername(String user_name) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select * from users where user_name = ?";
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	 User user=new User(rs.getString("user_name"),rs.getString("password"),rs.getString("phone_number"),
              		   rs.getString("credit_type"),rs.getString("credit_number"),rs.getString("email"),rs.getString("role"),rs.getString("college_name"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }
        return userList;
    }


    /**
     * 查询用户信息根据学号
     */

    public static List<User> getByNum(String user_id) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select * from users where user_id = ?";
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	User user = new User(rs.getString("user_name"), rs.getString("password"),rs.getString("phone_number"),
            			rs.getString("credit_type"), rs.getString("credit_number"),rs.getString("email"),rs.getString("role"),rs.getString("college_name"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }
        return userList;
    }

    /**
     * 修改密码根据用户名
     */

    public static int ChangePass(String new_password,String user_name) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "UPDATE users SET password=? WHERE user_name = ?";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, new_password);
            pstmt.setString(2, user_name);
            // 执行sql语句
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, conn);
        }
        return count;
    }


    /**
     * 修改邮箱根据用户名
     */

    public static int ChangeEamil(String new_emial,String user_name) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "UPDATE users SET email=? WHERE user_name = ?";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, new_emial);
            pstmt.setString(2, user_name);
            // 执行sql语句
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, conn);
        }
        return count;
    }
}

