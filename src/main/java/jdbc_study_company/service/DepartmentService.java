package jdbc_study_company.service;

import java.util.List;

import jdbc_study_company.dao.DepartmentDao;
import jdbc_study_company.dto.Department;

public class DepartmentService {
	private DepartmentDao dao;
	
	public List<Department> selectDepartmentByAll(){
		return dao.selectDepartmentByAll();
	}

}
