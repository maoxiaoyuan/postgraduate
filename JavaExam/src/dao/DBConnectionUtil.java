package dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



	public class DBConnectionUtil {
	    private static Connection conn =null;
	    private static PreparedStatement pstmt=null;
		private static Statement st=null;
		private static ResultSet rs=null;
		/**
		 * 获取数据库的连接
		 */
		public static Connection getConn() {
			String className = "com.mysql.jdbc.Driver";
			String username = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/postmysql";
			try {
				Class.forName(className);
				conn = DriverManager.getConnection(url, username, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
	
		//关闭资源
		public static void close() throws SQLException{
			try{
				if(rs!=null){
					rs.close();					
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		

		/**
		 * 关闭资源
		 */
		public static void close(PreparedStatement pstmt, Connection conn) {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		public static void closeup(Statement st, Connection conn) {

			try {
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

		/**
		 * 关闭资源
		 */
		public static void close(PreparedStatement pstmt, ResultSet rs,Connection conn) {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
