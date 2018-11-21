package jdbc_study_company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_study_company.dto.Title;
import jdbc_study_company.jdbc.ConnectionProvider;
import jdbc_study_company.jdbc.LogUtil;

public class TitleDaoImpl implements TitleDao {

	@Override
	public List<Title> selectTitleByAll() throws SQLException {
		List<Title> list = new ArrayList<>();
		String sql = "select tno, tname from title";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			while(rs.next()) {
				list.add(getTitle(rs));
			}
		}
		return list;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		String tNo = rs.getString("tno");
		String tName = rs.getString("tname");
		return new Title(tNo, tName);
	}

	@Override
	public int insertTitle(Title item) throws SQLException {
		System.out.println("insertTitle실행");
		String sql = "insert into title values(?,?)";
		int row = 0;
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, item.gettNo());
			pstmt.setString(2, item.gettName());
			LogUtil.prnLog(pstmt);
			row = pstmt.executeUpdate();
		}
		return row;
	}

	@Override
	public int deleteTitle(Title item) throws SQLException {
		System.out.println("deleteTitle실행");
		String sql = "delete from title where tno= ?";
		int row = 0;
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, item.gettNo());
			LogUtil.prnLog(pstmt);
			row = pstmt.executeUpdate();
		}
		return row;
	}

	@Override
	public int updateTitle(Title item) throws SQLException {
		System.out.println("updateTitle실행");
		String sql = "update title set tname = ? where tno = ? ";
		int row = 0;
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, item.gettName());
			pstmt.setString(2, item.gettNo());
			LogUtil.prnLog(pstmt);
			row = pstmt.executeUpdate();
		}
		return row;
	}
	
	

}




















