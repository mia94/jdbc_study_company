package jdbc_study_company;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jdbc_study_company.jdbc.ConnectionProvider;
import jdbc_study_company.jdbc.LogUtil;

public class ConnectionProviderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("Start ConnectionProviderTest");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("End ConnectionProviderTest");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println();
	}

	@Test
	public void SelectProductTest() {
		try(Connection connection = ConnectionProvider.getConnection()){
			LogUtil.prnLog(connection.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
