package jdbc_study_company.dao;

import java.util.List;

import jdbc_study_company.dto.Title;

public interface TitleDao {
	List<Title> selectTitleByAll();
}
