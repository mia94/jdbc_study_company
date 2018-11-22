package jdbc_study_company;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jdbc_study_company.dao.DepartmentDao;
import jdbc_study_company.dao.DepartmentDaoImpl;
import jdbc_study_company.dto.Department;
import jdbc_study_company.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {
	static DepartmentDao deptDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start Test");
		deptDao = new DepartmentDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("End Test");
		deptDao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	/*@Test
	public void test01selectDepartmentByAll(){
		List<Department> list = deptDao.selectDepartmentByAll();
		LogUtil.prnLog(list.toString());
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test02insertDepartment() throws SQLException {
		Department newDept = new Department("D006","자바",7);
		int row = deptDao.insertDepartment(newDept);
		LogUtil.prnLog("insert row : " + row);
		Assert.assertEquals(1, row);
		test01selectDepartmentByAll();
	}

	@Test
	public void test04deleteDepartment() throws SQLException {
		Department delDept = new Department("D006");
//		delDept.setDeptNo("D006");
		int row = deptDao.deleteDepartment(delDept);
		LogUtil.prnLog("delete row : " + row);
		Assert.assertEquals(1, row);
		test01selectDepartmentByAll();
	}
	
	@Test
	public void test03updateDepartment() throws SQLException {
		Department updateDept = new Department("D006","디비",7);
		int row = deptDao.updateDepartment(updateDept);
		LogUtil.prnLog("update row : " + row);
		Assert.assertEquals(1, row);
		test01selectDepartmentByAll();
	}*/
}



















