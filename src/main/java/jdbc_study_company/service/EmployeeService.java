package jdbc_study_company.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_company.dao.EmployeeDao;
import jdbc_study_company.dao.EmployeeDaoImpl;
import jdbc_study_company.dto.Employee;

public class EmployeeService {
	private EmployeeDao dao;

	public EmployeeService() {
		dao = new EmployeeDaoImpl();
	}
	
	public List<Employee> selectEmployeeByAll(){
		return dao.selectEmployeeByAll();
	}
	
	public int insertEmp(Employee item) throws SQLException {
		return dao.insertEmployee(item);
	}
	
	public int deleteEmp(Employee item) throws SQLException {
		return dao.deleteEmployee(item);
	}
	
	public int updateEmp(Employee item) throws SQLException {
		return dao.updateEmployee(item);
	}
	
	public String nextNoEmpNo() throws SQLException {
		return dao.nextNoEmployee();
	}
}
