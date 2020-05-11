package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Strategy;


public class StrategyDao {
	Strategy strategy;
	public StrategyDao() {
		strategy=new Strategy();
	}
    /**
     * 添加政策信息
     */
    public static int add(Strategy strategy) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "insert into strategies values(?,?,?,?)";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, strategy.getStrategy_id());
            pstmt.setString(2, strategy.getStrategy_type());
            pstmt.setString(3, strategy.getStrategy_content());
            pstmt.setString(4, strategy.getCollege_name());
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
     * 删除政策根据政策id
     */
    public static int delete(String strategy_id) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "DELETE FROM strategies WHERE strategy_id = ?";
        int count = 0;
        try {
            // 声明对象
            pstmt = conn.prepareStatement(sql);
            // 给占位符赋值
            pstmt.setString(1, strategy_id);
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
     * 查询所有政策信息
     */

    public static List<Strategy> query() {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select * from strategies";
        ResultSet rs = null;
        List<Strategy> strategyList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
               Strategy strategy=new Strategy(rs.getString("strategy_id"),rs.getString("strategy_type"),rs.getString("strategy_content"),
            		   rs.getString("college_name"));
                strategyList.add(strategy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }

        return strategyList;
    }
    /**
     * 查询政策信息根据college_name
     */

    public static List<Strategy> getByname(String college_name) {
        PreparedStatement pstmt = null;
        Connection conn = DBConnectionUtil.getConn();
        String sql = "select * from strategies where college_name = ?";
        ResultSet rs = null;
        List<Strategy> strategyList = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, college_name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	 Strategy strategy=new Strategy(rs.getString("strategy_id"),rs.getString("strategy_content"));
                strategyList.add(strategy);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.close(pstmt, rs, conn);
        }
        return strategyList;
    }
}
