package jdbc_study_company.dao;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_company.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll() throws SQLException;
	
	int selectTitle(Title item);
	int updateTitle(Title item);
	int deleteTitle(Title item);
}
