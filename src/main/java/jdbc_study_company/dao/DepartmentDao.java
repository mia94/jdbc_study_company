package jdbc_study_company.dao;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_company.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	
	int insertDepartment(Department department) throws SQLException;
}
