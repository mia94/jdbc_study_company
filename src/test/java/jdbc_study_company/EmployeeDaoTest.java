package jdbc_study_company;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jdbc_study_company.dao.EmployeeDao;
import jdbc_study_company.dao.EmployeeDaoImpl;
import jdbc_study_company.dto.Department;
import jdbc_study_company.dto.Employee;
import jdbc_study_company.dto.Gender;
import jdbc_study_company.dto.Title;
import jdbc_study_company.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	static EmployeeDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start Test");
		dao = new EmployeeDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("End Test");
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	@Test
	public void test01selectEmployeeByAll() {
		List<Employee> list = dao.selectEmployeeByAll();
		LogUtil.prnLog(list.toString());
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test02InsertEmployee() throws SQLException {
		Employee newEmp = new Employee("E017003","너부장",new Title("T001"),4000000,Gender.FEMALE,new Department("D002"),new Date());
		int row = dao.insertEmployee(newEmp);
		LogUtil.prnLog("Insert row :" + row);
		Assert.assertEquals(1, row);
		test01selectEmployeeByAll();
	}
	
	@Test
	public void test03deleteEmployee() throws SQLException {
		Employee delEmp = new Employee("E017001");
		delEmp.setEmpNo("E017001");
		int row = dao.deleteEmployee(delEmp);
		LogUtil.prnLog("delete row :" + row);
		Assert.assertEquals(1, row);
		test01selectEmployeeByAll();
	}
	
	@Test
	public void test04updateEmployee() throws SQLException {
		Employee updateEmp = new Employee("E017003","너부장2",new Title("T002"),40000002,Gender.FEMALE,new Department("D002"),new Date());
		int row = dao.updateEmployee(updateEmp);
		LogUtil.prnLog("update row :"+row);
		Assert.assertEquals(1, row);
		test01selectEmployeeByAll();
	}
}






















