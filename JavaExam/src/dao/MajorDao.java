package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Major;

public class MajorDao {
	Major major;
	public MajorDao() {
		major=new Major();
	}
    /**
     * 添加专业信息
     */
    public static int add(Major major) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "insert into majors values(?,?,?,?,?,?)";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, major.getCollege_name());
            pstmt.setString(2, major.getMajor_name());
            pstmt.setString(3, major.getMajor_rank());
            pstmt.setString(4, major.getInstitution());
            pstmt.setString(5, major.getPersons());
            pstmt.setString(6,major.getForm());

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
     * 更改专业信息
     */
    public static int update(Major major) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "UPDATE majors SET major_rank=?,institution=?," +
        		"persons=?,form=? WHERE college_name=? and major_name=?";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, major.getMajor_rank());
            pstmt.setString(2, major.getInstitution());
            pstmt.setString(3, major.getPersons());
            pstmt.setString(4, major.getForm());
            pstmt.setString(5, major.getCollege_name());
            pstmt.setString(6, major.getMajor_name());

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
     * 删除专业根据college_name,major_name
     */
    public static int delete(String college_name,String major_name) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "DELETE FROM majors WHERE college_name = ? and major_name=?";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, college_name);
            pstmt.setString(2, major_name);

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
     * 查询所有专业信息根据college_name
     */

    public static List<Major> getByName(String college_name) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select major_name,major_rank,institution,persons,form from majors where college_name=?";
        ResultSet rs = null;
        List<Major> majorList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, college_name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
               Major  major=new Major(rs.getString("major_name"),rs.getString("major_rank"),
            		   rs.getString("institution"),rs.getString("persons"),rs.getString("form"));
               majorList.add(major);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }
        return majorList;
    }


    /**
     * 查询所有专业信息
     */

    public static List<Major> query() {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select * from majors";
        ResultSet rs = null;
        List<Major> majorList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
               Major  major=new Major(rs.getString("college_name"),rs.getString("major_name"),rs.getString("major_rank"),
            		   rs.getString("institution"),rs.getString("persons"),rs.getString("form"));
               majorList.add(major);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }
        return majorList;
    }

}
