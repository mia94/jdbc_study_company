package jdbc_study_company.dao;

import java.util.List;

import jdbc_study_company.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
}
