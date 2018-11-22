package jdbc_study_company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;

import jdbc_study_company.dto.Department;
import jdbc_study_company.dto.Employee;
import jdbc_study_company.dto.Gender;
import jdbc_study_company.dto.Title;
import jdbc_study_company.jdbc.ConnectionProvider;
import jdbc_study_company.jdbc.LogUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Override
	public List<Employee> selectEmployeeByAll() {
			List<Employee> list = new ArrayList<>();
			String sql = "select e.empno, e.empname, t.tno , t.tname, e.salary, e.gender, d.deptname, d.floor, e.joindate from employee e join department d on e.deptno = d.deptno join title t on e.title = t.tno";
			try(Connection conn = ConnectionProvider.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery()){
				LogUtil.prnLog(pstmt);
				while(rs.next()) {
					list.add(getEmployee(rs));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return list;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		String empNo = rs.getString("empno");
		String empName = rs.getString("empname");
		Title title = new Title(rs.getString("tno"), rs.getString("tname"));
		int salary = rs.getInt("salary");
		Gender gender = rs.getInt("gender")==0?Gender.FEMALE:Gender.MALE;
		Department deptNo = new Department(rs.getString("deptname"), rs.getInt("floor"));
		Date joinDate = rs.getDate("joindate");
		return new Employee(empNo, empName, title, salary, gender, deptNo, joinDate);
	}

	@Override
	public int insertEmployee(Employee item) throws SQLException {
		return 0;
	}

	@Override
	public int deleteEmployee(Employee item) throws SQLException {
		String sql = "delete from employee where empno = ? ";
		int row = 0;
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, item.getEmpNo());
			LogUtil.prnLog(pstmt);
			row = pstmt.executeUpdate();
		}
		return row;
	}

	@Override
	public int updateEmployee(Employee item) throws SQLException {
		
		return 0;
	}

	@Override
	public String nextNoEmployee() throws SQLException {
		System.out.println("nextEmployee 실행");
		String sql = "select max(empno) nextno from employee";
		String nextNo = "";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			LogUtil.prnLog(pstmt);
			if(rs.next()) {			
				int no = Integer.parseInt(rs.getString("nextno").substring(4))+1;
				nextNo = String.format("E017%03d", no);
			}
		}
		return nextNo;
	}
	
}
