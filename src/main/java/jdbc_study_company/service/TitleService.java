package jdbc_study_company.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_company.dao.TitleDao;
import jdbc_study_company.dto.Title;

public class TitleService {
	private TitleDao dao;
	
	public List<Title> selectTitleByAll() throws SQLException{
		return dao.selectTitleByAll();
	}
	
	public int insertTitle(Title item) throws SQLException {
		return dao.insertTitle(item);
	}
}
