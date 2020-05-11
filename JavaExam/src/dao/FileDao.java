package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Book;
import bean.College;
import bean.Files;


public class FileDao {
	 public static void main(String[] args) {
//		  System.out.println(query());	 
		 FileDao fd=new FileDao();
			List<Files> fileList=new ArrayList<>();
			fileList=fd.query();
			System.out.print(fileList);
	    }
	public static int getDataBaseId() {
        int maxId = 0;// 存放最大的编号值，默认值设为0.
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn= DBConnectionUtil.getConn();
        String sql = "select max(file_id) from files ";
        try {
        	pstmt = conn.prepareStatement(sql);
        	rs = pstmt.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnectionUtil.close(pstmt, rs,conn);
        }
        return maxId + 1;
    }
	/*
	 * 增加文件信息
	 */
	public static int add(Files files) {
		Date date=new Date();     
    	Timestamp timeStamp =new Timestamp(date.getTime()) ;
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "insert into files values(?,?,?,?,?)";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setInt(1, getDataBaseId());
            pstmt.setString(2, files.getFile_name());
            pstmt.setString(3, files.getFile_path());
            pstmt.setString(4, files.getCollege().getCollege_name());
            pstmt.setTimestamp(5, timeStamp);

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
     * 删除文件根据文件id
     */
    public static int delete(int file_id) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "DELETE FROM files WHERE file_id = ?";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setInt(1, file_id);
            // 执行sql语句
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, conn);
        }
        return count;
    }
   
    public static String getTime(int file_id ) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select * from files where file_id=?";
        ResultSet rs = null;
        String time = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, file_id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("time"));
//            	time=rs.getTimestamp("ordertime");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }
        return time;
    }
    /**
     * 查询所有文件信息
     */

    public static List<Files> query() {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select * from files";
        ResultSet rs = null;
        List<Files> fileList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	Files files=new Files();
            	files.setFile_id(rs.getInt("file_id"));
            	files.setFile_name(rs.getString("file_name"));
            	files.setFile_path(rs.getString("file_path"));
            	files.setCollege(new College(rs.getString("college_name")));
            	files.setTime(rs.getTimestamp("time"));
                fileList.add(files);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }

        return fileList;
    }
}
