package jdbc_study_company.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_company.dao.TitleDao;
import jdbc_study_company.dao.TitleDaoImpl;
import jdbc_study_company.dto.Title;

public class TitleService {
	private TitleDao dao;

	public TitleService() {
		dao = new TitleDaoImpl();
	}

	public List<Title> selectTitleByAll() throws SQLException{
		return dao.selectTitleByAll();
	}
	
	public int insertTitle(Title item) throws SQLException {
		return dao.insertTitle(item);
	}
	
	public int deleteTitle(Title item) throws SQLException {
		return dao.deleteTitle(item);
	}
	
	public int updateTitle(Title item) throws SQLException {
		return dao.updateTitle(item);
	}
	
	public String nextNoTitle() throws SQLException {
		return dao.nextNoTitleNo();
	}
}

















