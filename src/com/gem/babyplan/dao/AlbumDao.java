package com.gem.babyplan.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gem.babyplan.entity.Album;
import com.gem.babyplan.entity.Classes;
import com.gem.babyplan.exception.AlbumRuntimeException;
import com.gem.babyplan.utils.DBConnection;

public class AlbumDao {
	// 插入
	public void save(Album album) {
		// 1.连数据库
		Connection conn = null;
		// 3.获得PreparedStatement对象
		PreparedStatement prep = null;

		try {
			conn = DBConnection.getConnection();
			// 2.sql语句
			String sql = "insert into album(classNumber,albumDescribe,coverPaper,createTime)" + "values(?,?,?,?)";
			prep = conn.prepareStatement(sql);
			// 4.设置？的值
			prep.setString(1, album.getClasses().getClassNumber());
			prep.setString(2, album.getAlbumDescribe());
			prep.setString(3, album.getCoverPaper());
			prep.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			// 5.执行sql语句
			prep.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册插入方法出错");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册插入方法出错");
		} catch (IOException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册插入方法出错");
		} finally {
			// 6.关闭资源
			DBConnection.release(conn, prep);
		}
	}

	// 删除，批量删除
	public void delete(int[] albumId) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "delete from album where albumId = ?";
			for (int i = 0; i < albumId.length; i++) {
				prep = conn.prepareStatement(sql);
				prep.setInt(1, albumId[i]);
				prep.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册删除方法出错");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册删除方法出错");
		} catch (IOException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册删除方法出错");
		} finally {
			DBConnection.release(conn, prep);
		}
	}

	// 修改
	public void update(Album album) {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "update album set classNumber=?,albumDescribe=?,coverPaper=?,createTime=? where albumId = ?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, album.getClasses().getClassNumber());
			prep.setString(2, album.getAlbumDescribe());
			prep.setString(3, album.getCoverPaper());
			prep.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			prep.setInt(5, album.getAlbumId());
			prep.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册修改方法出错");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册修改方法出错");
		} catch (IOException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册修改方法出错");
		} finally {
			DBConnection.release(conn, prep);
		}
	}

	// 查询所有相册
	public List<Album> selectAll() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Album> list = new ArrayList<Album>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select albumId,classNumber,albumDescribe,coverPaper,createTime from album";
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			while (rs.next()) {
				Classes classes = new Classes();
				classes.setClassNumber(rs.getString("classNumber"));
				
				Album album = new Album();
				album.setAlbumId(rs.getInt("albumId"));
				album.setClasses(classes);
				album.setAlbumDescribe(rs.getString("albumDescribe"));
				album.setCoverPaper(rs.getString("coverPaper"));
				album.setCreateTime(rs.getDate("createTime"));
				
				list.add(album);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册查询所有方法出错");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册查询所有方法出错");
		} catch (IOException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册查询所有方法出错");
		} finally {
			DBConnection.release(conn, prep, rs);
		}
		return list;
	}
	
	//分页查询
	public List<Album> getPagedAlbum(int curPage, int pageSize) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Album> list = new ArrayList<Album>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select albumId,classNumber,albumDescribe,coverPaper,createTime from album order by albumId limit ?,?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, (curPage - 1) * pageSize);
			prep.setInt(2, pageSize);
			rs = prep.executeQuery();
			while (rs.next()) {
				Classes classes = new Classes();
				classes.setClassNumber(rs.getString("classNumber"));
				
				Album album = new Album();
				album.setAlbumId(rs.getInt("albumId"));
				album.setClasses(classes);
				album.setAlbumDescribe(rs.getString("albumDescribe"));
				album.setCoverPaper(rs.getString("coverPaper"));
				album.setCreateTime(rs.getDate("createTime"));
				list.add(album);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册分页查询方法出错");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册分页查询方法出错");
		} catch (IOException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册分页查询方法出错");
		} finally {
			DBConnection.release(conn, prep, rs);
		}
		return list;
	}
	
	//获得所有相册的个数
	public int getCount() {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			String sql = "select count(*) c from album";
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			while (rs.next()) {
				count = rs.getInt("c");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册获得所有相册个数方法出错");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册获得所有相册个数方法出错");
		} catch (IOException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册获得所有相册个数方法出错");
		} finally {
			DBConnection.release(conn, prep, rs);
		}
		return count;
	}
	
	//根据主键相册id获得相册信息
	public Album getAlbumByAlbumId(int albumId) {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		Album album = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select albumId,classNumber,albumDescribe,coverPaper,createTime from album where albumId=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, albumId);
			rs = prep.executeQuery();
			if (rs.next()) {
				Classes classes = new Classes();
				classes.setClassNumber(rs.getString("classNumber"));
				
				album = new Album();
				album.setAlbumId(rs.getInt("albumId"));
				album.setClasses(classes);
				album.setAlbumDescribe(rs.getString("albumDescribe"));
				album.setCoverPaper(rs.getString("coverPaper"));
				album.setCreateTime(rs.getDate("createTime"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册根据主键获得相册方法出错");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册根据主键获得相册方法出错");
		} catch (IOException e) {
			e.printStackTrace();
			throw new AlbumRuntimeException("相册根据主键获得相册方法出错");
		} finally {
			DBConnection.release(conn, prep, rs);
		}
		return album;
	}
}
