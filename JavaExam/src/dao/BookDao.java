package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Book;

public class BookDao {
	/**
     * 添加书籍信息
     */
	Book book;
	public BookDao() {
		book=new Book();
		
	}
    public static int add(Book book) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "insert into books values(?,?,?)";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, book.getBook_name());
            pstmt.setFloat(2, book.getPrice());
            pstmt.setString(3, book.getBook_type());
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
     * 更改书籍信息
     */
    public static int update(Book book) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "UPDATE books SET price=?,book_type=?  WHERE book_name=?";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setFloat(1, book.getPrice());
            pstmt.setString(2, book.getBook_type());
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
     * 删除书籍根据书名
     */
    public static int delete(String book_name) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "DELETE FROM books WHERE book_name = ?";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, book_name);
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
     * 查询所有书籍信息
     */

    public static List<Book> query() {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select * from books";
        ResultSet rs = null;
        List<Book> bookList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book(rs.getString("book_name"),  rs.getFloat("price"), rs.getString("book_type"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }

        return bookList;
    }
    /**
     * 查询书籍信息根据书名
     */

    public static List<Book> getByBookname(String book_name) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select * from books where book_name = ?";
        ResultSet rs = null;
        List<Book> bookList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book_name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	Book book = new Book(rs.getString("book_name"),  rs.getFloat("price"), rs.getString("book_type"));
                bookList.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }
        return bookList;
    }
}
