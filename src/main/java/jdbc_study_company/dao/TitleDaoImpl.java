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
	public int selectTitle(Title item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTitle(Title item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTitle(Title item) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}




















