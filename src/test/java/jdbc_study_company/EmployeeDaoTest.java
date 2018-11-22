package jdbc_study_company;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jdbc_study_company.dao.EmployeeDao;
import jdbc_study_company.dao.EmployeeDaoImpl;
import jdbc_study_company.dto.Employee;
import jdbc_study_company.jdbc.LogUtil;

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
	public void test03deleteEmployee() throws SQLException {
		Employee delEmp = new Employee("E017001");
		delEmp.setEmpNo("E017001");
		int row = dao.deleteEmployee(delEmp);
		LogUtil.prnLog("delete row :" + row);
		Assert.assertEquals(1, row);
		test01selectEmployeeByAll();
	}
}






















