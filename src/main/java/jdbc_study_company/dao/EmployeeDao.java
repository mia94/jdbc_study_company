package jdbc_study_company.dao;

import java.sql.SQLException;
import java.util.List;
import jdbc_study_company.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
	
	int insertEmployee(Employee item) throws SQLException;
	int deleteEmployee(Employee item) throws SQLException;
	int updateEmployee(Employee item) throws SQLException;
	
	String nextNoEmployee() throws SQLException;
}
