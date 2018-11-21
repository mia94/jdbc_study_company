package jdbc_study_company;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jdbc_study_company.dao.TitleDao;
import jdbc_study_company.dao.TitleDaoImpl;
import jdbc_study_company.dto.Title;
import jdbc_study_company.jdbc.LogUtil;

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

}






















