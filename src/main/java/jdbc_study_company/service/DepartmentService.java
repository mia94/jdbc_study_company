package jdbc_study_company.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_company.dao.DepartmentDao;
import jdbc_study_company.dao.DepartmentDaoImpl;
import jdbc_study_company.dto.Department;

public class DepartmentService {
	private DepartmentDao dao;

	public DepartmentService() {
		dao = new DepartmentDaoImpl();
	}

	public List<Department> selectDepartmentByAll(){
		return dao.selectDepartmentByAll();
	}
	
	public int insertDept(Department item) throws SQLException {
		return dao.insertDepartment(item);
	}
	
	public int deleteDept(Department item) throws SQLException {
		return dao.deleteDepartment(item);
	}
	
	public int updeteDept(Department item) throws SQLException {
		return dao.updateDepartment(item);
	}
	public String nextNoDeptNo() throws SQLException {
		return dao.nextNoDepartment();
	}
}


























