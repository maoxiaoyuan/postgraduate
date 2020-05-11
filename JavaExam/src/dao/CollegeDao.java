package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.College;

public class CollegeDao {
	/**
     * 
     */
    public static int add(College college) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "insert into college values(?,?,?,?,?,?,?)";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, college.getCollege_id());
            pstmt.setString(2, college.getCollege_name());
            pstmt.setString(3, college.getCollege_type());
            pstmt.setString(4, college.getCollege_city());
            pstmt.setString(5, college.getCollege_rank());
            pstmt.setString(6, college.getCollege_phone());
            pstmt.setString(7, college.getCollege_email());

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
     * 查询所有高校信息
     */

    public static List<College> query() {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select * from college";
        ResultSet rs = null;
        List<College> collegeList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
               College college=new College(rs.getString("college_id"),rs.getString("college_name"),rs.getString("college_type"),
            		   rs.getString("college_city"),rs.getString("college_rank"),rs.getString("college_phone"),rs.getString("college_email"));
                collegeList.add(college);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }

        return collegeList;
    }
}
