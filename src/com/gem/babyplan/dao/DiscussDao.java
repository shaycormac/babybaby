package com.gem.babyplan.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.gem.babyplan.entity.Discuss;
import com.gem.babyplan.entity.Dynamic;
import com.gem.babyplan.entity.Parent;
import com.gem.babyplan.exception.DiscussRuntimeException;
import com.gem.babyplan.utils.DBConnection;

public class DiscussDao {
	// 插入
	public void save(Discuss discuss) {
		// 1.连数据库
		Connection conn = null;
		// 3.获得PreparedStatement对象
		PreparedStatement prep = null;

		try {
			conn = DBConnection.getConnection();
			// 2.sql语句
			String sql = "insert into discuss(dynamicId,parentId,discussSuperId,discussPublishTime,discussText,isLast)"
					+ "values(?,?,?,?,?,?)";
			prep = conn.prepareStatement(sql);
			// 4.设置？的值
			prep.setInt(1, discuss.getDynamic().getDynamicId());
			prep.setInt(2, discuss.getParent().getParentId());
			int discussSuperId = discuss.getDiscuss().getDiscussId();
			if(discussSuperId == 0){
				prep.setNull(3, Types.INTEGER);
			}else{
				prep.setInt(3, discussSuperId);
			}
			prep.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			prep.setString(5, discuss.getDiscussText());
			prep.setInt(6, discuss.getIsLast());
			// 5.执行sql语句
			prep.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DiscussRuntimeException("评论插入方法出错");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DiscussRuntimeException("评论插入方法出错");
		} catch (IOException e) {
			e.printStackTrace();
			throw new DiscussRuntimeException("评论插入方法出错");
		} finally {
			// 6.关闭资源
			DBConnection.release(conn, prep);
		}
	}

	// 删除,批量删除
	public void delete(int discussId , int discussSuperId) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from discuss where discussId = ? or discussSuperId = ?";
			
			prep = conn.prepareStatement(sql);
			prep.setInt(1, discussId);
			prep.setInt(2, discussSuperId);
			prep.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DiscussRuntimeException("评论删除方法出错");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DiscussRuntimeException("评论删除方法出错");
		} catch (IOException e) {
			e.printStackTrace();
			throw new DiscussRuntimeException("评论删除方法出错");
		} finally {
			DBConnection.release(conn, prep);
		}
	}

	// 查询所有评论
	public List<Discuss> selectAll() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Discuss> list = new ArrayList<Discuss>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select discussId,dynamicId,parentId,discussSuperId,discussPublishTime,discussText,isLast from discuss";
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			while (rs.next()) {
				Discuss discuss = new Discuss();
				Dynamic dynamic = new Dynamic();
				dynamic.setDynamicId(rs.getInt("dynamicId"));
				Parent parent = new Parent();
				parent.setParentId(rs.getInt("parentId"));
				Discuss discuss1 = new Discuss();
				discuss1.setDiscussId(rs.getInt("discussId"));

				discuss.setDiscussId(rs.getInt("discussId"));
				discuss.setDynamic(dynamic);
				discuss.setParent(parent);
				discuss.setDiscuss(discuss1);
				discuss.setDiscussPublishTime(rs.getTimestamp("discussPublishTime"));
				discuss.setDiscussText(rs.getString("discussText"));
				discuss.setIsLast(rs.getInt("isLast"));
				list.add(discuss);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DiscussRuntimeException("评论查询所有方法出错");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DiscussRuntimeException("评论查询所有方法出错");
		} catch (IOException e) {
			e.printStackTrace();
			throw new DiscussRuntimeException("评论查询所有方法出错");
		} finally {
			DBConnection.release(conn, prep, rs);
		}
		return list;
	}
}
