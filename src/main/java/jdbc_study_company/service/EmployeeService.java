package jdbc_study_company.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_study_company.dao.DepartmentDao;
import jdbc_study_company.dao.DepartmentDaoImpl;
import jdbc_study_company.dao.EmployeeDao;
import jdbc_study_company.dao.EmployeeDaoImpl;
import jdbc_study_company.dao.TitleDao;
import jdbc_study_company.dao.TitleDaoImpl;
import jdbc_study_company.dto.Department;
import jdbc_study_company.dto.Employee;
import jdbc_study_company.dto.Title;

public class EmployeeService {
	private EmployeeDao dao;
	private DepartmentDao deptDao;
	private TitleDao titleDao;

	public EmployeeService() {
		dao = new EmployeeDaoImpl();
		deptDao = new DepartmentDaoImpl();
		titleDao = new TitleDaoImpl();
	}
	
	public List<Employee> selectEmployeeByAll(){
		return dao.selectEmployeeByAll();
	}
	
	public List<Department> selectDeptByAll(){
		return deptDao.selectDepartmentByAll();
	}
	
	public List<Title> selectTitleByAll() throws SQLException{
		return titleDao.selectTitleByAll();
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
