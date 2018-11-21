package jdbc_study_company;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jdbc_study_company.dao.TitleDao;
import jdbc_study_company.dao.TitleDaoImpl;
import jdbc_study_company.dto.Title;
import jdbc_study_company.jdbc.LogUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest {
	static TitleDao titleDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start Test");
		titleDao = new TitleDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start Test");
		titleDao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	@Test
	public void test01selectTitleByAll() throws SQLException {
		List<Title> list = titleDao.selectTitleByAll();
		LogUtil.prnLog(list.toString());
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test02insertTitle() throws SQLException {
		Title title = new Title("T006","인턴");
		int row = titleDao.insertTitle(title);
		LogUtil.prnLog("insert row : "+ row);
		Assert.assertEquals(1, row);
		test01selectTitleByAll();
	}
	
	@Test
	public void test04deleteTitle() throws SQLException {
		Title delTitle = new Title("T006");
		int row = titleDao.deleteTitle(delTitle);
		LogUtil.prnLog("delete row : "+ row);
		Assert.assertEquals(1, row);
		test01selectTitleByAll();
	}

}






















