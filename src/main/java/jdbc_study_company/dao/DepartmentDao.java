package jdbc_study_company.dao;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_company.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	
	int insertDepartment(Department item) throws SQLException;
	int deleteDepartment(Department item) throws SQLException;
	int updateDepartment(Department item) throws SQLException;
	
}
