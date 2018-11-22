package jdbc_study_company.dao;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_company.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll() throws SQLException;
	
	int insertTitle(Title item) throws SQLException;
	int updateTitle(Title item) throws SQLException;
	int deleteTitle(Title item) throws SQLException;
	
	String nextNoTitleNo() throws SQLException;
}
